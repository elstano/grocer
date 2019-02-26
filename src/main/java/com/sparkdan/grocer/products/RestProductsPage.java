package com.sparkdan.grocer.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparkdan.grocer.Product;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
public class RestProductsPage {
    int current;
    int rowCount;
    int total;
    List<Product> rows;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Product> getRows() {
        return rows;
    }

    public void setRows(List<Product> rows) {
        this.rows = rows;
    }
}
