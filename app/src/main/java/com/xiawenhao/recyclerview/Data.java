package com.xiawenhao.recyclerview;

import java.util.ArrayList;

public class Data {
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_HEADER = 1;

    public int type;
    public String title;
    public String description;
    public int count;
    public String avatar;

    public Data(int type, String title, String description, int lastDataCount, int count) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.count = count;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public static int lastDataCount = 0;

    static ArrayList<Data> creatMultipleList(int size) {
        ArrayList<Data> dataList = new ArrayList<>();
        dataList.add(new Data(TYPE_HEADER, "This is header", null, lastDataCount, lastDataCount++));
        for (int i = 1; i < size + 1; i++) {
            dataList.add(new Data(TYPE_ITEM, "Title" + lastDataCount, "Description" + lastDataCount, lastDataCount, lastDataCount++));
        }
        lastDataCount = 0;
        return dataList;
    }


}



