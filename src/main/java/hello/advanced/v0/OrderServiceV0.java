package hello.advanced.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderReposotiryV0 orderReposotiry;

    public void orderItem(String itemId) {
        orderReposotiry.save(itemId);
    }
}
