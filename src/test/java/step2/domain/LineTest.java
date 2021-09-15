package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void movableFalseAndRightTest() {
        final Line line = new Line(Arrays.asList(false, true, false, true));
        final Position position = line.movable(new Position(0));
        assertThat(position.isRight()).isTrue();
    }

    @Test
    void movableFalseAndDownTest() {
        final Line line = new Line(Arrays.asList(false, true, false, false));
        final Position position = line.movable(new Position(2));
        assertThat(position.isDown()).isTrue();
    }

    @Test
    void movableFalseAndDownTest2() {
        final Line line = new Line(Arrays.asList(false, true, false, false));
        final Position position = line.movable(new Position(3));
        assertThat(position.isDown()).isTrue();
    }

    @Test
    void movableTrueAndLeftTest() {
        final Line line = new Line(Arrays.asList(false, true, false, true));
        final Position position = line.movable(new Position(1));
        assertThat(position.isLeft()).isTrue();
    }

    @Test
    void movableTrueAndDownTest() {
        final Line line = new Line(Arrays.asList(true, false, false, true));
        final Position position = line.movable(new Position(0));
        assertThat(position.isDown());
    }
}
