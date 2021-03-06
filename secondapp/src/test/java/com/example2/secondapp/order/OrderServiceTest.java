package com.example2.secondapp.order;

import com.example2.secondapp.AppConfig;
import com.example2.secondapp.member.Grade;
import com.example2.secondapp.member.Member;
import com.example2.secondapp.member.MemberService;
import com.example2.secondapp.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "Test member", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "Test item", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
