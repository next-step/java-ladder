package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LinesTest {

    @DisplayName("Lines 생성 시, height 크기의 List<Line> lines 변수를 갖는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void Should_Be_Same_With_Height_When_Create_Lines(int height) {
        LineGenerationStrategy lineGenerationStrategy = new RandomLineGenerationStrategy();
        int countOfPerson = 5;
        Lines lines = Lines.of(lineGenerationStrategy, countOfPerson, height);

        Assertions.assertThat(lines.getLines().size()).isEqualTo(height);
    }
}
