package com.codegym.freshfood.message.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class DateForm {
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date firstDate;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastDate;

    public DateForm() {
    }

    public DateForm(@NotBlank Date firstDate, @NotBlank Date lastDate) {
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}
