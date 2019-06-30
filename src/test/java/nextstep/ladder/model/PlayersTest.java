package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {
    @DisplayName("Players 이름에 LPAD(6자리 공백) 포함 한 줄 출력")
    @Test
    void getFormattedNameTest() {
        assertThat(new Players("Jack, Jim, Loen, Su, Rocky")
                .getFormattedName())
                .isEqualTo("  Jack   Jim  Loen    Su Rocky");
    }

    @DisplayName("Players 이름 중 다섯 자리 초과 존재 시, 예외 발생")
    @Test
    void splitNameTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players("Jack, Samuel, Loen");
        });
    }
}
