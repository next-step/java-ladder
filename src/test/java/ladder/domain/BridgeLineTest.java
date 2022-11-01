package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeLineTest {

    @DisplayName("사다리 다리 라인 생성")
    @Test
    void create() {
        BridgeLine bridgeLine = new BridgeLine(List.of(true, false, true, true));
        assertThat(bridgeLine)
                .isEqualTo(new BridgeLine(List.of(true, false, true, true)));
    }
}
