package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}