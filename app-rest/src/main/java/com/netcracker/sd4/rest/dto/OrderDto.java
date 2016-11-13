package com.netcracker.sd4.rest.dto;

import java.sql.Date;

public class OrderDto {
    private int cast;
    private Date date;

    public int getCast() {
        return cast;
    }

    public void setCast(int cast) {
        this.cast = cast;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
