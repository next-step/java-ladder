package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 높이에 맞게 라인이 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void line_size(int height) {
        // given
        int countOfPerson = 5;

        // when
        Ladder ladder = Ladder.of(height, countOfPerson, () -> Boolean.TRUE);

        // then
        assertThat(ladder.getLines().size()).isEqualTo(height);
    }

    @DisplayName("사다리 최종 결과 index가 반환된다")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"})
    void getResultIndex(int startIndex, int expectedResultIndex) {
        // given
        int countOfPerson = 5;
        int height = 5;

        // when
        Ladder ladder = Ladder.of(height, countOfPerson, () -> Boolean.TRUE);
        // TRUE FALSE TRUE FALSE FALSE
        // TRUE FALSE TRUE FALSE FALSE
        // TRUE FALSE TRUE FALSE FALSE
        // TRUE FALSE TRUE FALSE FALSE
        // TRUE FALSE TRUE FALSE FALSE
        // 0 -> 1
        // 1 -> 0
        // 2 -> 3
        // 3 -> 2
        // 4 -> 4

        // then
        assertThat(ladder.getResultIndex(startIndex)).isEqualTo(expectedResultIndex);
    }
}