package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThatCode(() -> Ladder.create(5, 3))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리 길이 입력 값 검증")
    void checkLadderHeight(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.create(0, 3))
        .withMessageContaining("사다리 길이가 0 이하 입니다.");

    }

}
