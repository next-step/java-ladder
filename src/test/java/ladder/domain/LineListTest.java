package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineListTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 5})
    @DisplayName("사람 수대로 Line 생성")
    void createLine(int countOfPerson) {
        LineList lineList = new LineList();
        lineList.createLine(countOfPerson);

        int result = lineList.getLineList().get(0).getPoints().size();
        assertThat(result).isEqualTo(countOfPerson);
    }
}
