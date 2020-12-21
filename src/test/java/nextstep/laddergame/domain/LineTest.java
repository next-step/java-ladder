package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    void create() {
        int people = 5;
        Line line = new Line(people);
        assertThat(line).isNotNull();
    }

    @Test
    @DisplayName(value = "한 라인에서 좌우로 움직이는지 테스트")
    void Move() {
        int people = 3;
        Line line = new Line(people);
        System.out.println(line.getPoints().size());
        assertThat(line).isNotNull();

        Point firstIndex = line.getPoints()
                .stream()
                .filter(point -> point.getIndex() == 0)
                .findFirst().get();

        firstIndex.canRight();
        assertThat(firstIndex.move()).isEqualTo(1);

        Point secondIndex = line.getPoints()
                .stream()
                .filter(point -> point.getIndex() == 1)
                .findFirst().get();


        secondIndex.canLeft();
        assertThat(secondIndex.move()).isEqualTo(0);

        Point lastIndex = line.getPoints()
                .stream()
                .filter(point -> point.getIndex() == 2)
                .findFirst().get();


        lastIndex.canNotMove();
        assertThat(lastIndex.move()).isEqualTo(2);
    }

    @Test
    @DisplayName(value = "존재하지 않는 Index가 들어오면 RuntimeException")
    void move_hasNotPlace_RuntimeException() {
        int people = 3;
        Line line = new Line(people);
        assertThat(line).isNotNull();

        assertThatThrownBy(() -> line.moveByIndex(10))
                .isInstanceOf(RuntimeException.class);

    }
}