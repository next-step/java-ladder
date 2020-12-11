package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameResultTest {

    private User user;

    @BeforeEach
    void setUp() {
        this.user = User.of("TEST");
    }

    @Test
    @DisplayName("GameResult 동일한 유저,보상 값을 가진 객체 비교")
    void gameResult_of_isEqualTo() {
        GameResult actual = GameResult.of(user,"꽝");
        assertThat(actual).isEqualTo(GameResult.of(User.of("TEST"),"꽝"));
    }

    @Test
    @DisplayName("GameResult contains() 인수값이 Null 또는 공백인 경우 NullPointerException 발생")
    void gameResult_containsIsBlank_throwNullPointException() {
        assertThatThrownBy(() -> {
            GameResult actual = GameResult.of(user,"꽝");
            actual.contains("");
        }).isInstanceOf(NullPointerException.class)
            .hasMessageContaining("유저이름에 Null 또는 공백이 올 수 없습니다.");
    }
}
