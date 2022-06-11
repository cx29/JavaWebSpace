package com.example.demo.domain;

public class Results {
    Object data;
    String flag;
    Object pages;

    public Results() {
    }

    public Results(Object data, String flag, Object pages) {
        this.data = data;
        this.flag = flag;
        this.pages = pages;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Object getPages() {
        return pages;
    }

    public void setPages(Object pages) {
        this.pages = pages;
    }
}
