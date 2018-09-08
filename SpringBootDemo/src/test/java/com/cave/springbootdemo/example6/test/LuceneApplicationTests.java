package com.cave.springbootdemo.example6.test;

import com.cave.springbootdemo.example6.LuceneApplication;
import com.cave.springbootdemo.example6.service.LuceneSearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = {LuceneApplication.class})
public class LuceneApplicationTests {

    @Autowired
    private LuceneSearch luceneSearch;

    @Test
    public void testIKAnalyzer(){
        luceneSearch.testIKAnalyzer();
    }

}
