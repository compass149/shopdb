package org.pgm.shopserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication //@SpringBootApplication이게 적혀있으면 컴포넌트에서 내려온 거라서 bean을 주입받아서 쓸 수 있음
public class ShopServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServerApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
