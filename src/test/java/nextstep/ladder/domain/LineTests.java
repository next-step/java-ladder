package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTests {
    @DisplayName("참여하는 인원수를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int countOfPerson = 3;
        Line line = Line.create(countOfPerson);
        assertThat(line).isNotNull();
    }

    @DisplayName("첫번째 칸에는 무조건 다리를 놓을 수 없다.")
    @Test
    void firstLadderMustFalseTest() {
        int countOfPerson = 1;
        Line line = Line.create(countOfPerson);
        assertThat(line.getPointsIndex(0)).isFalse();
    }

    @DisplayName("다리가 없는 칸 다음의 칸에는 다리를 놓을 수 있다.")
    @Test
    void canMakeLadderAfterNoneLadder() {
        int countOfPerson = 2;
        Line line = Line.create(countOfPerson);
        assertThat(line.getPointsIndex(0)).isFalse();
        assertThat(line.getPointsIndex(1)).isTrue();
    }

    @DisplayName("이전칸에 다리가 놓였다면 이후 칸에는 다리를 놓을 수 없다.")
    @Test
    void cantMakeLadderAfterLadder() {
        int countOfPerson = 3;
        Line line = Line.create(countOfPerson);
        assertThat(line.getPointsIndex(0)).isFalse();
        assertThat(line.getPointsIndex(1)).isTrue();
        assertThat(line.getPointsIndex(2)).isFalse();
    }
}
