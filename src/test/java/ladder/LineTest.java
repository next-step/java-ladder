package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

    @Test
    @DisplayName("게임 참가자가 한명 이하인 경우 예외처리가 발생한다.")
    void countOfPersonBelow_1() {
        int countOfPerson = 1;
        Assertions.assertThatThrownBy(() -> {
            new Line(countOfPerson);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    @DisplayName("한 라인의 축은 사람 수 만큼 생성된다.")
    void oneLineComposedByCountPeople(int countOfPerson) {
        Line line = new Line(countOfPerson);
        line.draw(() -> true);
        Assertions.assertThat(line.getPoints().size()).isEqualTo(countOfPerson);
    }

    @Test
    @DisplayName("한 라인의 선은 겹칠 수 없다.")
    void notOverlapInSameLine() {
        int countOfPerson = 2;
        Line line = new Line(countOfPerson);

        line.draw(() -> true);

        Assertions.assertThat(line.getPoints().get(0)).isEqualTo(new Point(true));
        Assertions.assertThat(line.getPoints().get(1)).isEqualTo(new Point(false));
    }
}

