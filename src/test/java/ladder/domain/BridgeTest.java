package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    @Test
    @DisplayName("동등성 테스트")
    void isEqual() {
        assertThat(new Bridge(true).equals(new Bridge(true))).isTrue();
    }
}
