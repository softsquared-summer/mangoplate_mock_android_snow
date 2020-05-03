package com.softsquared.mangoplate_snow.src.main.discount.toplist;

public class TopList {
    private String topListIntroduce;
    private String topListDetail;
    private String topListSeeCounter;
    private String topListDayAgo;
//    private URL imgUrl;

    public TopList(String topListIntroduce, String topListDetail, String topListSeeCounter, String topListDayAgo) {
        this.topListIntroduce = topListIntroduce;
        this.topListDetail = topListDetail;
        this.topListSeeCounter = topListSeeCounter;
        this.topListDayAgo = topListDayAgo;
    }

    public String getTopListIntroduce() {
        return topListIntroduce;
    }

    public void setTopListIntroduce(String topListIntroduce) {
        this.topListIntroduce = topListIntroduce;
    }

    public String getTopListDetail() {
        return topListDetail;
    }

    public void setTopListDetail(String topListDetail) {
        this.topListDetail = topListDetail;
    }

    public String getTopListSeeCounter() {
        return topListSeeCounter;
    }

    public void setTopListSeeCounter(String topListSeeCounter) {
        this.topListSeeCounter = topListSeeCounter;
    }

    public String getTopListDayAgo() {
        return topListDayAgo;
    }

    public void setTopListDayAgo(String topListDayAgo) {
        this.topListDayAgo = topListDayAgo;
    }
}
