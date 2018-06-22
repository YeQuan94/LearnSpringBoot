package com.cave.springbootdemo.example3.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于配置Druid连接池，相关内容集成在一个Config中
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidDataSourceConfig {

    @Bean
    @Primary // 主数据源
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }


    /**
     * 使用@Bean的方式配置Servlet需要使用ServletRegistrationBean
     * Servlet-chain来配置Servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        // 关联Servlet
        servletRegistrationBean.setServlet(new StatViewServlet());
        // 添加拦截路径
        servletRegistrationBean.addUrlMappings("/druid/*");
        // 添加初始化参数
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername", "admin"); // 账号
        initParameters.put("loginPassword", "admin"); // 密码
        initParameters.put("resetEnable", "false");   // 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.setInitParameters(initParameters);

        return servletRegistrationBean;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
