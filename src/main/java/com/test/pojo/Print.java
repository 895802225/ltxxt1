package com.test.pojo;

import org.springframework.context.annotation.Bean;

public class Print {

    private String code;
    private String year;
    private String month;
    private String count;

    public Print() {
    }

    public Print(String code, String year, String month, String count) {
        this.code = code;
        this.year = year;
        this.month = month;
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
