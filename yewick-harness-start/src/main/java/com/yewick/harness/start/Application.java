package com.yewick.harness.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动入口。
 *
 * <p>负责装配并启动整个 Harness 应用，通过组件扫描加载各层的 Bean。</p>
 */
@SpringBootApplication(scanBasePackages = "com.yewick.harness")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
