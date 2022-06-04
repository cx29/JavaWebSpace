package com.example.demo.domain;

public class Result {
   Object data;
   String flag;

    public Result() {
    }

    public Result(Object data, String flag) {
        this.data = data;
        this.flag = flag;
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
}
