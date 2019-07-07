package domain.bridge;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGeneratorTest {
    @Test
    public void 난이도에_따른_다리생성() {
        //given
        int limitValue = 3;
        BridgeGenerator bridgeGenerator = new BridgeRandomGenerator(limitValue);

        //when
        boolean result = bridgeGenerator.generate(Boolean.TRUE);

        //then
        assertThat(result).isFalse();
    }
}
