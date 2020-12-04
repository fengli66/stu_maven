package com.lifeng.pojo;

import java.io.Serializable;

public class PageIndexer implements Serializable {
    private int pageIndex;//页码
    private int pageSize;//每页行数
    private int pageCount;//总页数

    public PageIndexer() {

    }

    public PageIndexer(int pageIndex, int pageSize, int pageCount) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
