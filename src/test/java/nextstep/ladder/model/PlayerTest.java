package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @DisplayName("입력한 이름에 LPAD(6자리 공백)")
    @Test
    void getNameTest() {
        assertThat(new Player("Jack").getName()).isEqualTo("  Jack");
    }
}
