package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GiftTest {
    @Test
    @DisplayName("상품의 이름이 5글자가 넘어가면 IllegalArgumentException 발생한다.")
    void name() {
        assertThatThrownBy(() -> {
            String name = "testtest";
            new Gift(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
