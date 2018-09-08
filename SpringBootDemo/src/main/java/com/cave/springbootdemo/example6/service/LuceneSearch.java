package com.cave.springbootdemo.example6.service;

import com.cave.springbootdemo.example6.pojo.Anime;

import java.util.List;

public interface LuceneSearch {

    /**
     * 添加单个索引
     * @param anime
     */
    void addDocument(Anime anime);

    /**
     * 添加所有索引
     */
    void addAllDocument();

    /**
     * 查询所有文档
     */
    List<Anime> searchAll();


    /**
     * 测试IK分词器结果，主要是繁体和简体
     */
    void testIKAnalyzer();

}
