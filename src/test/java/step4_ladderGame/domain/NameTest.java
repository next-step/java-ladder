package step4_ladderGame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @DisplayName("플레이어의 이름은 5글자이다.")
    @Test
    void testCase1() {
        Assertions.assertThatThrownBy(() -> {
            Name.of("sixsix");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
