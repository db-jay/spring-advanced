package hello.advanced.trace.template;

import hello.advanced.trace.LogTrace;
import hello.advanced.trace.TraceStatus;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;

        try {
            status = trace.begin(message);

            //로직이 호출되어야 함
            T result = call();
            trace.end(status);

            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    // call 메서드를 선언하고 try구문에서 상속으로 구현할 수 있도록 함.
    protected abstract T call();
}
