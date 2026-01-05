package hello.advanced.trace.helloTrace.strategy;

import hello.advanced.trace.helloTrace.strategy.code.stratgy.ContextV1;
import hello.advanced.trace.helloTrace.strategy.code.stratgy.Strategy;
import hello.advanced.trace.helloTrace.strategy.code.stratgy.StrategyLogic1;
import hello.advanced.trace.helloTrace.strategy.code.stratgy.StrategyLogic2;
import hello.advanced.trace.helloTrace.template.code.AbstractTemplate;
import hello.advanced.trace.helloTrace.template.code.SubClassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /* 전략패턴 사용 */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);

        contextV1.execute();
        contextV2.execute();
    }

    @Test
    void StrategyV2() {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("business logic 1 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();
        
        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("business logic 2 실행");
            }
        };

        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void StrategyV3() {
        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("business logic 1 실행");
            }
        });
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("business logic 2 실행");
            }
        });
        contextV2.execute();
    }

    /* Lambda 사용 */
    @Test
    void StrategyV4() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("business logic 1 실행"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("business logic 2 실행"));
        contextV2.execute();
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1(); // SubClassLogic1()을 호출
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic1(); // SubClassLogic1()을 호출
        template2.execute();
    }

    @Test
    void TemplateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate(){

            @Override
            protected void call() {
                log.info("익명 내부클래스 비즈니스 로직 1 실행");
            }
        };
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate(){

            @Override
            protected void call() {
                log.info("익명 내부클래스 비즈니스 로직 2 실행");
            }
        };
        template2.execute();
    }

}
