package ru.geekbrains.controller;

public class ProductListParams {

    private String productnameFilter;

    private Integer priceFilter;

    private Integer page;

    private Integer size;

    private String sortField;

    public String getProductnameFilter() {
        return productnameFilter;
    }

    public void setProductnameFilter(String productnameFilter) {
        this.productnameFilter = productnameFilter;
    }

    public Integer getPriceFilter() {
        return priceFilter;
    }

    public void setPriceFilter(Integer priceFilter) {
        this.priceFilter = priceFilter;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }
}
