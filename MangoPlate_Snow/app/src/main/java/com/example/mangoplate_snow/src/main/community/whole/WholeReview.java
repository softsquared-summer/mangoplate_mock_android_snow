package com.example.mangoplate_snow.src.main.community.whole;

public class WholeReview {
    //    private URL imgUrl; 프로필 사진
    //    private URL imgUrl; 유저 업로드 사진 아마 arraylist가 될 것 같음
    private String userNickname;
    private String reviewCount;         //댓글 갯수
    private String followerCount;
    private String restaurantNameAndLocation;
    private String userReview;
    private String likeCount;
    private String commentCount;
    private String timeAgo;                 //리뷰 업로드 후 경과시간
    private boolean isWannagoChecked;
    private boolean isLikeChecked;
    private int overallAssess;       //리뷰 오른쪽 상단 평가

    public WholeReview(String userNickname, String reviewCount, String followerCount, String restaurantNameAndLocation, String userReview, String likeCount, String commentCount, String timeAgo, boolean isWannagoChecked, boolean isLikeChecked, int overallAssess) {
        this.userNickname = userNickname;
        this.reviewCount = reviewCount;
        this.followerCount = followerCount;
        this.restaurantNameAndLocation = restaurantNameAndLocation;
        this.userReview = userReview;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.timeAgo = timeAgo;
        this.isWannagoChecked = isWannagoChecked;
        this.isLikeChecked = isLikeChecked;
        this.overallAssess = overallAssess;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(String followerCount) {
        this.followerCount = followerCount;
    }

    public String getRestaurantNameAndLocation() {
        return restaurantNameAndLocation;
    }

    public void setRestaurantNameAndLocation(String restaurantNameAndLocation) {
        this.restaurantNameAndLocation = restaurantNameAndLocation;
    }

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    public boolean isWannagoChecked() {
        return isWannagoChecked;
    }

    public void setWannagoChecked(boolean wannagoChecked) {
        isWannagoChecked = wannagoChecked;
    }

    public boolean isLikeChecked() {
        return isLikeChecked;
    }

    public void setLikeChecked(boolean likeChecked) {
        isLikeChecked = likeChecked;
    }

    public int getOverallAssess() {
        return overallAssess;
    }

    public void setOverallAssess(int overallAssess) {
        this.overallAssess = overallAssess;
    }
}
