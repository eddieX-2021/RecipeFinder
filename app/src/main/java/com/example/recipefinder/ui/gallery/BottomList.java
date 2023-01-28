package com.example.recipefinder.ui.gallery;

public class BottomList {
    private String url;
    private String selectImg;
    private String uncheckedImg;
    private String shelfPath;
    private String shelfName;
    private String shelfType;
    private int uncheckedResId;
    private int checkedResId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSelectImg() {
        return selectImg;
    }

    public void setSelectImg(String selectImg) {
        this.selectImg = selectImg;
    }

    public String getUncheckedImg() {
        return uncheckedImg;
    }

    public void setUncheckedImg(String uncheckedImg) {
        this.uncheckedImg = uncheckedImg;
    }

    public String getShelfPath() {
        return shelfPath;
    }

    public void setShelfPath(String shelfPath) {
        this.shelfPath = shelfPath;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public String getShelfType() {
        return shelfType;
    }

    public void setShelfType(String shelfType) {
        this.shelfType = shelfType;
    }

    public int getUncheckedResId() {
        return uncheckedResId;
    }

    public void setUncheckedResId(int uncheckedResId) {
        this.uncheckedResId = uncheckedResId;
    }


    public int getCheckedResId() {
        return checkedResId;
    }

    public void setCheckedResId(int checkedResId) {
        this.checkedResId = checkedResId;
    }
}
