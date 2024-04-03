package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @DisplayName("Bridge 유무를 확인한다.")
    @Test
    void test01() {
        Bridge bridge = new Bridge(true);
        assertThat(bridge.has()).isTrue();
    }
}
