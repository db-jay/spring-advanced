package hello.advanced.v0;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static java.lang.Thread.sleep;


@Repository
@RequiredArgsConstructor
public class OrderReposotiryV0 {

    public void save(String itemId) {
        // 저장로직

        if(itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생");
        }

        sleep(1000);
    }

    private void sleep(int mills ){
        try{
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
