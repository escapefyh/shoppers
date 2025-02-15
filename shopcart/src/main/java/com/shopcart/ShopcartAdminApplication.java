package com.shopcart;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * Hello world!
 *
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages ="com.shopcart.mapper")
public class ShopcartAdminApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ShopcartAdminApplication.class,args);
    }
}
