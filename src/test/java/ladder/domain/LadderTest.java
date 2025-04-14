package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {
    @Test
    @DisplayName("높이 만큼 사다리의 line이 생성되었는지 확인한다.")
    void lineCreationTest() {
        int height = 5;
        int countOfPlayer = 3;
        int countOfResult = 3;
        Ladder ladder = new Ladder(height, countOfPlayer, countOfResult);

        Assertions.assertEquals(height, ladder.getLines().size());
    }

    @Test
    @DisplayName("플래이어 수와 결과 수가 다르면 예외를 발생한다.")
    void validateSizeTest() {
        int height = 5;
        int countOfPlayer = 3;
        int countOfResult = 2;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(height, countOfPlayer, countOfResult));
    }
}
