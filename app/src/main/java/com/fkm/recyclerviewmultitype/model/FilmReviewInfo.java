package com.fkm.recyclerviewmultitype.model;

/**
 * 影评信息表
 */
public class FilmReviewInfo extends BaseModel {

    // 标题
    private String title;
    // 作者
    private String author;
    // 封面图片
    private String coverImg;
    // 封面图片类型
    private int coverImgType;
    // 发表日期
    private String publishedDate;
    // 跳转类型
    private int jumpType;
    // 文本内容
    private String textContent;
    // 内容图片Url
    private String contentImgUrl;
    // 浏览数量
    private int pageView;
    // 点赞数量
    private int likesAmount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getCoverImgType() {
        return coverImgType;
    }

    public void setCoverImgType(int coverImgType) {
        this.coverImgType = coverImgType;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getJumpType() {
        return jumpType;
    }

    public void setJumpType(int jumpType) {
        this.jumpType = jumpType;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getContentImgUrl() {
        return contentImgUrl;
    }

    public void setContentImgUrl(String contentImgUrl) {
        this.contentImgUrl = contentImgUrl;
    }

    public int getPageView() {
        return pageView;
    }

    public void setPageView(int pageView) {
        this.pageView = pageView;
    }

    public int getLikesAmount() {
        return likesAmount;
    }

    public void setLikesAmount(int likesAmount) {
        this.likesAmount = likesAmount;
    }

}
