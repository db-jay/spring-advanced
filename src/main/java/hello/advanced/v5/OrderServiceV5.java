package hello.advanced.v5;

import hello.advanced.trace.LogTrace;
import hello.advanced.trace.callback.TraceTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderReposotiryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderReposotiryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

//        template.execute("OrderService.orderItem()", new TraceCallback<>() {
//            @Override
//            public Void call() {
//                orderRepository.save(itemId);
//                return null;
//            }
//        });

        /* lambda */
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}