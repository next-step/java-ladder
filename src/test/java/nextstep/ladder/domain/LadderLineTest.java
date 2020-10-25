package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 100})
    @DisplayName("사다리 라인(가로줄) 생성 테스트")
    void createHorizontalLineTest(int countOfPersons) {
        LadderLine line = LadderLine.of(countOfPersons);
        int lineCount = line.getLegs().size();

        assertThat(lineCount).isEqualTo(countOfPersons - 1);
    }
}
