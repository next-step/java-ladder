package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 100})
    @DisplayName("사다리 라인(가로줄) 생성 테스트")
    void createHorizontalLineTest(int countOfPersons) {
        Line line = Line.of(countOfPersons);
        int lineCount = line.getCount();

        assertThat(lineCount).isEqualTo(countOfPersons - 1);
    }
}
