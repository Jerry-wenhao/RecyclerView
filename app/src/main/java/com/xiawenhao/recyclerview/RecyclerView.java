package com.xiawenhao.recyclerview;

public class RecyclerView {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RecyclerView(String title, int count, String description) {
        this.title = title;
        this.count = count;
        this.description = description;
    }

    private  int count;
    private String description;

}
