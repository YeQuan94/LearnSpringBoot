package com.cave.springbootdemo.example6.web;

import com.cave.springbootdemo.example6.pojo.Anime;
import com.cave.springbootdemo.example6.service.LuceneSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lucene")
public class LuceneController {

    @Autowired
    private LuceneSearch luceneSearch;

    @GetMapping("/search")
    public Object search(Anime searchAnime){

        return null;
    }

    @GetMapping("/addAllIndex")
    public void addAllIndex(){
        luceneSearch.addAllDocument();
    }

}
