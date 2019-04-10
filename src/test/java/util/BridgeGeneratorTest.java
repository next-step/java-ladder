package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGeneratorTest {
    @Test
    public void generateBridge() {
        boolean result = BridgeGenerator.generate(Boolean.TRUE);
        assertThat(result).isFalse();
    }
}
