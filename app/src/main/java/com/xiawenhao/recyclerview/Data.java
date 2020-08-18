package com.xiawenhao.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public String title;
    public String description;
    public int count;

    public Data(String title, String description, int lastDataCount, int count) {
        this.title = title;
        this.description = description;
        this.count = count;
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

    public static int lastDataCount = 0;
    static ArrayList<Data> createDataList(int size) {
        List<Data> dataList = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            dataList.add(new Data("Title"+ lastDataCount, "Description" + lastDataCount, lastDataCount, lastDataCount++));
        }
        return (ArrayList<Data>) dataList;
    }


}


