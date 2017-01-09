package com.lvg.ndtcenter;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by Victor Levchenko LVG Corp. on 09.01.17.
 */

@EnableAutoConfiguration
@Component
@ComponentScan
public class WebStarter {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WebStarter.class);
        app.run(args);
    }
}
