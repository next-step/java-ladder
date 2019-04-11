package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGeneratorTest {

    @Test
    public void generateBridge() {
        BridgeGenerator bridgeGenerator = new BridgeRandomGenerator();
        boolean result = bridgeGenerator.generate(Boolean.TRUE);
        assertThat(result).isFalse();

    }
}
