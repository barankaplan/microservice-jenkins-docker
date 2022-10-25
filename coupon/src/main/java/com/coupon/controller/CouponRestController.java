package com.coupon.controller;


import com.coupon.entity.Coupon;
import org.springframework.web.bind.annotation.*;
import com.coupon.repo.CouponRepository;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

    private final CouponRepository couponRepository;

    public CouponRestController(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }


    @RequestMapping(value = "/coupons",method = RequestMethod.POST)
//    @PostMapping("/coupons")
//    @ResponseStatus(HttpStatus.CREATED)
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }

    @GetMapping(value = "/coupons/{id}")
    public Coupon getCoupon(@PathVariable("id") String id){
        return couponRepository.findCouponByCode(id);
    }

}
