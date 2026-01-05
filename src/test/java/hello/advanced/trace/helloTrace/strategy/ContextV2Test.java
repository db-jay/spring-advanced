package hello.advanced.trace.helloTrace.strategy;

import hello.advanced.trace.helloTrace.strategy.code.stratgy.ContextV2;
import hello.advanced.trace.helloTrace.strategy.code.stratgy.StrategyLogic1;
import hello.advanced.trace.helloTrace.strategy.code.stratgy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {


    //    parameter 전략 패턴 적용
    @Test
    void StrategyV1() {
        ContextV2 context = new ContextV2();

        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    //    parameter 전략 패턴 람다 적용
    @Test
    void StrategyV2() {
        ContextV2 context = new ContextV2();

        context.execute(() -> log.info("람다 1 실행"));
        context.execute(() -> log.info("람다 2 실행"));
    }
}
