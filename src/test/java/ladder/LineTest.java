package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("한 라인의 축은 사람 수 만큼 생성된다.")
    void oneLineComposedByCountPeople(int countOfPerson) {
        Line line = new Line(countOfPerson);
        Assertions.assertThat(line.getPoints().size()).isEqualTo(countOfPerson);
    }
}

