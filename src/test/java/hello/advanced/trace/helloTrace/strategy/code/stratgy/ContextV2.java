package hello.advanced.trace.helloTrace.strategy.code.stratgy;

import lombok.extern.slf4j.Slf4j;

/* 전략을 파라미터로 전달 받는 방식 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) { // 전략을 prarmeter로 전달받아 위임하는 패턴 (execute 메서드)

        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        strategy.call(); // Context Strategy (위임)

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
