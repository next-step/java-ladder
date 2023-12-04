package ladder.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 다섯글자_초과_실행_결과_입력_시_에러() {
        assertThatThrownBy(() -> new GameResult("aaaaaa")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사다리 결과는 5자 이하만 입력가능합니다.");
    }
}
