package com.rental.QO;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseInfoForm {
    public static int DEFAULT_PAGE_NUM = 1;
    public static int DEFAULT_PAGE_SIZE = 10;

    protected Integer pageNumber;
    protected Integer pageSize;
    protected String order;
    protected String sortField;
    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNum) {
        this.pageNumber = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public <E> Page<E> getPage() {
        if (pageNumber == null || pageSize == null) {
            return null;
        }

        Page page = new Page(pageNumber, pageSize);
        if (!StringUtils.isBlank(sortField) && !StringUtils.isBlank(order)) {
            page.setOpenSort(true);
            page.setOrderByField(humpToLine(sortField));
            page.setAsc(order.equalsIgnoreCase("asc"));
        }
        return page;
    }

    public <E> Page<E> createPage() {
        Page page = new Page<>(DEFAULT_PAGE_NUM, DEFAULT_PAGE_SIZE);
        if (!StringUtils.isBlank(sortField) && !StringUtils.isBlank(order)) {
            page.setOpenSort(true);
            page.setOrderByField(humpToLine(sortField));
            page.setAsc(order.equalsIgnoreCase("asc"));
        }
        return page;
    }

    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
