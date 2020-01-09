package com.walt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @FileName: bill-parent
 * @Author: wushang
 * @Description: TODO
 * @Date: 2020/1/8 10:53 下午
 */

@SpringBootApplication
public class BillWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillWebApplication.class, args);
        System.out.println("消费者启动");
    }
}
