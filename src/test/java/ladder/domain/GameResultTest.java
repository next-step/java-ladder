package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {
            "pobi:pobi:true",
            "crong:kim:false",
            "jk:pobi:false",
            "honux:honux:true"
    }, delimiter = ':')
    @DisplayName("GameResult contains() 존재하는 유저명/존재하지 않는 유저명 확인 시 예상되는 결과값 테스트")
    void gameResult_contains_isEqualTo(String actualUser,String expectUser, Boolean expectResult) {
        GameResult actual = GameResult.of(User.of(actualUser),"꽝");
        assertThat(actual.contains(expectUser)).isEqualTo(expectResult);
    }
}
