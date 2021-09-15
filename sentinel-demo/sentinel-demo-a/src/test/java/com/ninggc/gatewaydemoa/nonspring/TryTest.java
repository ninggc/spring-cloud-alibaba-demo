package com.ninggc.sentineldemoa.nonspring;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class TryTest {
    @Before
    public void before() {
        RuleInitializer.initRule();
    }

    @Test
    public void tryTest() {
        // 1.5.0 版本开始可以利用 try-with-resources 特性
        // 资源名可使用任意有业务语义的字符串，比如方法名、接口名或其它可唯一标识的字符串。
        try (Entry entry = SphU.entry("resourceName")) {
            // 被保护的业务逻辑
            // do something here...

        } catch (BlockException ex) {
            // 资源访问阻止，被限流或被降级
            // 在此处进行相应的处理操作
        }
    }
}
