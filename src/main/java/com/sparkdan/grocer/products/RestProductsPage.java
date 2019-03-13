package com.sparkdan.grocer.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparkdan.grocer.Product;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
public class RestProductsPage {
    int current;
    Integer rowCount;
    Long total;
    List<Product> rows;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Product> getRows() {
        return rows;
    }

    public void setRows(List<Product> rows) {
        this.rows = rows;
    }
}
