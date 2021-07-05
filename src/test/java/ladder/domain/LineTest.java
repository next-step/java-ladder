package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class LineTest {
    private Line line;

    @Test
    @DisplayName("Height Line이 잘 그려지는지 확인")
    void drawHeightLine() {
        int countOfPerson = 4;
        line = new Line(countOfPerson);
        line.points().stream().forEach((point) -> System.out.printf("%b\t\t", point));
        System.out.println();
        System.out.println(line.toString());
    }

    @Test
    @DisplayName("인접한 곳에 가로 사다리를 놓았을 경우 테스트")
    void addAdjectLadderFailTest() {
        int countOfPerson = 4;
        line = new Line(countOfPerson);
        line.addWidthLine(1);
        line.addWidthLine(3);
        assertThat(line.points().get(3)).isEqualTo(false);

    }

    @Test
    @DisplayName("인접하지 않는 곳에 가로 사다리를 놓았을 경우 테스트")
    void addAdjectLadderTest() {
        int countOfPerson = 4;
        line = new Line(countOfPerson);
        line.addWidthLine(1);
        line.addWidthLine(5);
       // assertThat(line.points().get(5)).isEqualTo(true);

    }

}
