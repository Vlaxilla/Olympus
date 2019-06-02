package com.rental.common;



import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 *Paging class?
 */
public class PageBean<T> {
    /**
     * Page Number,starting at 1
     */
    private int pageNum;
    /**
     * The page size
     */
    private int pageSize;
    /**
     * The total number of 
     */
    private long total;
    /**
     * Total number of pages
     */
    private long pages;
    /**
     *Data
     */
    private List<T> data;

    public PageBean(){}

    public PageBean(Page page){
        this.pageNum = page.getCurrent();
        this.pages = page.getPages();
        this.pageSize = page.getSize();
        this.total = page.getTotal();
        this.data = page.getRecords();

    }

    /**
     *
     * @param data Non-pages list,fake paged
     */
    public PageBean(List<T> data) {
        this.data = data;
        this.pageNum = 1;
        this.pages = 1;
        this.pageSize = data.size();
        this.total = data.size();
    }

    public PageBean(List<T> data,Integer pageNum,Integer pageSize,Integer total) {
        this.data = data;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        if (total == 0) {
            this.pages = 0;
            this.pageNum = 0;
        }
        this.pages = this.total / this.pageSize;
        if (this.total % this.pageSize != 0) {
            this.pages++;
        }

    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", pages=" + pages +
                ", data=" + data +
                '}';
    }
}
