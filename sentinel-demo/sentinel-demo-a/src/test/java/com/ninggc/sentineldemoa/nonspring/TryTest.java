package com.ninggc.sentineldemoa.nonspring;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
public class TryTest {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    @BeforeAll
    public static void before() {
        RuleInitializer.initRule();
    }

    @Test
    public void tryTest() {
        asyncExecute(20, (i) -> {

            // 0.5.0 版本开始可以利用 try-with-resources 特性
            // 资源名可使用任意有业务语义的字符串，比如方法名、接口名或其它可唯一标识的字符串。
            try (Entry entry = SphU.entry(RuleInitializer.TEST_RESOURCE)) {
                // 被保护的业务逻辑
                // do something here...
                log.info("enter resource time {}", i);
            } catch (BlockException ex) {
                // 资源访问阻止，被限流或被降级
                // 在此处进行相应的处理操作
                log.error("blocked resource time {}", i);
            }

            return null;
        });
    }

    private void asyncExecute(final int time, Function<Integer, Void> function) {
        CountDownLatch countDownLatch = new CountDownLatch(time);
        for (int i = 0; i < time; i++) {
            int finalI = i;
            executorService.submit(() -> {
                function.apply(finalI);
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
