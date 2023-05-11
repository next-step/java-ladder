package ladder.domain;

import ladder.strategy.RandomLadderStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 테스트")
class LadderTest {

    @DisplayName("넓이 또는 높이가 유효하지 않으면 사다리 생성에 실패한다")
    @ParameterizedTest
    @CsvSource({"3, 0", "2, -3"})
    void createLinesWithInvalidArguments(int width, int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(width, height, new RandomLadderStrategy()))
                .withMessage("사다리 높이는 양수여야 합니다");
    }

    @DisplayName("유효한 사다리 넓이와 높이를 전달하면 정상적으로 사다리를 생성한다")
    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 3", "4, 4", "5, 5"})
    void createLines(int countOfPerson, int height) {
        Ladder ladder = new Ladder(countOfPerson, height, new RandomLadderStrategy());
        Assertions.assertThat(ladder.fetchLines().size()).isEqualTo(height);
    }
}
