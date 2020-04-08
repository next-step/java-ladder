package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GamersTest {
    @Test
    @DisplayName(",로 이름들 받아서 생성")
    void ofCommaTest() {
        String name = "unit0 , unit1, unit2";
        assertThat(
                Gamers.ofComma(name)
                        .getGamers()
                        .stream()
                        .distinct())
                .hasSize(3);
    }

    @Test
    @DisplayName("두명 미만 에러")
    void expectExceptionTest() {
        String name = "unit0";
        assertThatThrownBy(() -> Gamers.ofComma(name))
                .isInstanceOf(RuntimeException.class);
    }
}
