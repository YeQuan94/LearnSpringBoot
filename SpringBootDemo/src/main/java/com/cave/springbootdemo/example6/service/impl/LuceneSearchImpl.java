package com.cave.springbootdemo.example6.service.impl;

import com.cave.springbootdemo.example6.dao.mapper.AnimeMapper;
import com.cave.springbootdemo.example6.pojo.Anime;
import com.cave.springbootdemo.example6.service.LuceneSearch;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional
public class LuceneSearchImpl implements LuceneSearch {

    @PostConstruct
    public void init(){
        try {

            // Lucene的索引方式有两种：RAM（内存）, FS（硬盘）
            // Lucene 7 使用的是nio，这里要使用Paths来获取Path
            this.directory = FSDirectory.open(Paths.get(luceneIndexPath));

            // FS目录读取
            this.reader = DirectoryReader.open(directory);

            // 需要配置Lucene的分词器
            // 目前市面上比较广泛的有：IKAnalyzer，MMSeg4j还有一个Lucene提供的分词器
            // 在Lucene 7 当中已经不需要指定version这个变量，存在默认值，在AbstractAnalysisFactory中配置了
            this.config = new IndexWriterConfig(new IKAnalyzer());

            // Index写入 需要 Lucene索引存储路径 和 Lucene相关配置
            this.writer = new IndexWriter(directory, config);

            // Index搜索 需要FS目录
            this.searcher = new IndexSearcher(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addDocument(Anime anime) {
        List<Anime> animes = animeMapper.selectAll();
        System.out.println(animes);
    }

    @Override
    public void addAllDocument() {
        Long startTime = System.currentTimeMillis();

        List<Anime> animes = animeMapper.selectAll();

        try {
            // 将表数据添加到索引中
            for (Anime anime : animes) {
                // 设置文档相关的Field域
                Document document = new Document();

                Field id = new LongPoint("id", anime.getId());
                Field idStore = new StoredField("id", anime.getId());
                Field title = new TextField("title", anime.getTitle(), Field.Store.YES);
                Field torrentName = new TextField("torrentName", anime.getTorrent_name(), Field.Store.NO);
                Field content = new StringField("content", anime.getContent(), Field.Store.YES);
                // 图片有可能存在空
                String mainPic = "";
                if (anime.getMain_pic() != null){

                    mainPic = anime.getMain_pic();

                }
                Field mainPicF = new StoredField("mainPic", mainPic);
                Field length = new LongPoint("length", anime.getFile_size());
                Field lengthStore = new StoredField("length", anime.getFile_size());
                Field createtime = new LongPoint("createtime", anime.getCreatetime().getTime());
                Field createtimeStore = new StoredField("createtime", anime.getCreatetime().getTime());

                document.add(id);
                document.add(idStore);
                document.add(title);
                document.add(torrentName);
                document.add(content);
                document.add(mainPicF);
                document.add(length);
                document.add(lengthStore);
                document.add(createtime);
                document.add(createtimeStore);

                writer.addDocument(document);
            }

            writer.commit();

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Long endTime = System.currentTimeMillis();

        System.out.println("Total Time : " + (endTime - startTime));
    }

    @Override
    public List<Anime> searchAll() {

        IKAnalyzer ikAnalyzer = new IKAnalyzer();

        // field 是搜索的字段
        String[] fields = {"title", "content"};

        MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, ikAnalyzer);

        // Lucene 7 的多条件查询需要用Builder
        BooleanQuery.Builder builder = new BooleanQuery.Builder();

        try {
            Query parse = queryParser.parse("*");

            builder.add(parse, BooleanClause.Occur.MUST);

            searcher.search(parse, 100);

        } catch (Exception e) {
            e.printStackTrace();
        }



        return null;
    }

    @Override
    public void testIKAnalyzer() {
        Analyzer analyzer = new IKAnalyzer();
        TokenStream stream = analyzer.tokenStream("title", new StringReader("紫羅蘭永恆花園"));
        CharTermAttribute charTermAttribute = stream.addAttribute(CharTermAttribute.class);

        try {
            stream.reset();
            while (stream.incrementToken()) {
                System.out.println(charTermAttribute.toString());
            }
            stream.end();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private AnimeMapper animeMapper;

    @Value("${lucene.index.path}")
    private String luceneIndexPath;

    private Directory directory;

    private IndexWriterConfig config;

    private IndexWriter writer;

    private DirectoryReader reader;

    private IndexSearcher searcher;

}
