package com.test.service;

import com.test.util.Ping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestPing {
    public static String IP_ADDRESS="218.197.98.75";
    @Scheduled(cron="0 0/5 *  * * ? ")
    public void test() throws Exception {
        Ping.ping02(IP_ADDRESS);
        System.out.println("======分割线====");
    }

}
