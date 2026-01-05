package hello.advanced.trace.callback;

import hello.advanced.trace.LogTrace;
import hello.advanced.trace.TraceStatus;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
            TraceStatus status = null;

            try {
                status = trace.begin(message);

                //로직이 호출되어야 함
                T result = callback.call();
                trace.end(status);

                return result;
            } catch (Exception e) {
                trace.exception(status, e);
                throw e;
            }
    }
}
