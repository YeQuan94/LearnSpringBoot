package com.cave.springbootdemo.example6.pojo;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "ANIME")
public class Anime {

    private Long id;

    private Long user_id;

    private Long group_id;

    private String content_p;

    private String content;

    private String title;

    private String main_pic;

    private String torrent_name;

    private Date createtime;

    private Date updatetime;

    private Long visit;

    private Long download;

    private Long file_size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public String getContent_p() {
        return content_p;
    }

    public void setContent_p(String content_p) {
        this.content_p = content_p;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMain_pic() {
        return main_pic;
    }

    public void setMain_pic(String main_pic) {
        this.main_pic = main_pic;
    }

    public String getTorrent_name() {
        return torrent_name;
    }

    public void setTorrent_name(String torrent_name) {
        this.torrent_name = torrent_name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getVisit() {
        return visit;
    }

    public void setVisit(Long visit) {
        this.visit = visit;
    }

    public Long getDownload() {
        return download;
    }

    public void setDownload(Long download) {
        this.download = download;
    }

    public Long getFile_size() {
        return file_size;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", group_id=" + group_id +
                ", content_p='" + content_p + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", main_pic='" + main_pic + '\'' +
                ", torrent_name='" + torrent_name + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", visit=" + visit +
                ", download=" + download +
                ", file_size=" + file_size +
                '}';
    }
}
