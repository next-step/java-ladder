package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class LineTest {
    private Line line;

    @Test
    @DisplayName("Height Line이 잘 그려지는지 확인")
    void drawHeightLineTest() {
        int countOfPerson = 3;
        line = new Line(countOfPerson);
        line.addHeightLine(0);
        line.addHeightLine(2);
        line.addHeightLine(4);

        assertAll(
                () -> assertThat(line.isDrawAtPosition(0)).isTrue(),
                () -> assertThat(line.isDrawAtPosition(1)).isFalse(),
                () -> assertThat(line.isDrawAtPosition(2)).isTrue(),
                () -> assertThat(line.isDrawAtPosition(3)).isFalse(),
                () -> assertThat(line.isDrawAtPosition(4)).isTrue()
        );
    }

    @Test
    @DisplayName("Width Line이 잘 그려지는지 확인")
    void drawWidthLineTest() {
        int countOfPerson = 3;
        line = new Line(countOfPerson);
        line.addHeightLine(0);
        line.addWidthLine(1);
        line.addHeightLine(2);
        line.addHeightLine(4);

        assertAll(
                () -> assertThat(line.isDrawAtPosition(0)).isTrue(),
                () -> assertThat(line.isDrawAtPosition(1)).isTrue(),
                () -> assertThat(line.isDrawAtPosition(2)).isTrue(),
                () -> assertThat(line.isDrawAtPosition(3)).isFalse(),
                () -> assertThat(line.isDrawAtPosition(4)).isTrue()
        );
    }

    @Test
    @DisplayName("인접하게 Width Line이 안그려지는지 확인")
    void drawWidthLineErrorTest() {
        int countOfPerson = 3;
        line = new Line(countOfPerson);
        line.addHeightLine(0);
        line.addWidthLine(1);
        line.addHeightLine(2);
        line.addWidthLine(3);
        line.addHeightLine(4);

        assertAll(
                () -> assertThat(line.isDrawAtPosition(0)).isTrue(),
                () -> assertThat(line.isDrawAtPosition(1)).isTrue(),
                () -> assertThat(line.isDrawAtPosition(2)).isTrue(),
                () -> assertThat(line.isDrawAtPosition(3)).isFalse(),
                () -> assertThat(line.isDrawAtPosition(4)).isTrue()
        );
    }

    @Test
    @DisplayName("Line Ladder 탐색")
    public void findRouteTest() {
        int countOfPerson = 3;
        User tom = new User("tom", 0);
        User jerry = new User("jerry", 2);
        User jane = new User("jane", 4);

        line = new Line(countOfPerson);
        line.addHeightLine(0);
        line.addWidthLine(1);
        line.addHeightLine(2);
        line.addHeightLine(4);

        assertAll(
                () -> assertThat(line.findRoute(tom.position())).isEqualTo(2),
                () -> assertThat(line.findRoute(jerry.position())).isEqualTo(0),
                () -> assertThat(line.findRoute(jane.position())).isEqualTo(4)
        );
    }
}
