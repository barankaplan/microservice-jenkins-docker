package com.product.repo;


import com.product.dto.Coupon;
import com.product.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = {Product.class, Coupon.class})
//@ActiveProfiles("test")

@TestPropertySource(locations="classpath:test.properties")

class ProductTest {

    @Test()
    @DisplayName("JUnit-Test.")
    void givenOperationOffices_whenCheckData_AAMP_Test() {
        Product product=new Product();
        Coupon coupon=new Coupon();
        coupon.setCode("ABCSALE");
        coupon.setDiscount(BigDecimal.valueOf(25));
        coupon.setExpDate(LocalDate.parse("2025-01-01"));


        product.setName("waschmaschine");
        product.setDescription("kalite marka");
        product.setPrice(BigDecimal.valueOf(125));
        product.setCouponCode("ABCSALE");

        assertThat(coupon.getCode()).isEqualTo("ABCSALE");
        assertThat(product.getPrice().compareTo(BigDecimal.valueOf(100))).isEqualTo(1);

    }

}