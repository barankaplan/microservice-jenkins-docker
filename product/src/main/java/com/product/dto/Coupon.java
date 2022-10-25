package com.product.dto;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


public class Coupon {


    private String code;
    private BigDecimal discount;
    private LocalDate expDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }
}
