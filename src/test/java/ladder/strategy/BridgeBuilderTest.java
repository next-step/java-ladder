package ladder.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.strategy.BridgeBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeBuilderTest {
    @Test
    @DisplayName("미리 입력한 곳에 사다리 포인트 만들기")
    void createPreDefinedBridgePointTest() {
        List<String> predefined = Arrays.asList("0,2", "1", "0", "1", "0,2");

        BridgeBuilder bridgeBuilder = new BridgeBuilder(predefined);

        assertThat(bridgeBuilder.getBuildPoints(0)).isEqualTo(Arrays.asList(0, 2));
        assertThat(bridgeBuilder.getBuildPoints(1)).isEqualTo(Arrays.asList(1));
        assertThat(bridgeBuilder.getBuildPoints(2)).isEqualTo(Arrays.asList(0));
        assertThat(bridgeBuilder.getBuildPoints(3)).isEqualTo(Arrays.asList(1));
        assertThat(bridgeBuilder.getBuildPoints(4)).isEqualTo(Arrays.asList(0, 2));
    }
}
