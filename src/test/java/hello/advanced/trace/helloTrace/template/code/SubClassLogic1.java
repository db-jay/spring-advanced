package hello.advanced.trace.helloTrace.template.code;

public class SubClassLogic1 extends AbstractTemplate{
    @Override
    protected void call() {
        System.out.println("서브로직을 통한 비즈니스 로직 1 실행");
    }
}
