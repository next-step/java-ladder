package step1.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class BridgeTest {

    @Test
    @DisplayName("전 라인의 Bridge가 Open이라면 다음 라인의 Bridge는 Closed이어야한다.")
    void fromBeforeLineBridge() {
        then(Bridge.fromBeforeLineBridge(new Bridge(true))).isEqualTo(new Bridge(false));
    }

    @Test
    void createAllClosedBridges() {
        then(Bridge.createAllClosedBridges(2))
            .isEqualTo(List.of(new Bridge(false), new Bridge(false)));
    }
}