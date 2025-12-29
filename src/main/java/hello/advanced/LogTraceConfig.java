package hello.advanced;

import hello.advanced.trace.LogTrace;
import hello.advanced.trace.threadlocal.code.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        // return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }
}
