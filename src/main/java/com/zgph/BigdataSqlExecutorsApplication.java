package com.zgph;

import com.zgph.utils.NotBugUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lyw
 */
@SpringBootApplication
public class BigdataSqlExecutorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigdataSqlExecutorsApplication.class, args);
        NotBugUtil.pritNoBug();
    }

}
