package com.example2.secondapp.discount;

import com.example2.secondapp.annotation.MainDiscountPolicy;
import com.example2.secondapp.member.Grade;
import com.example2.secondapp.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
