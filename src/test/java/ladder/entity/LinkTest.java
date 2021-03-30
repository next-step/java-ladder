package ladder.entity;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinkTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0x7fffffff})
    void canGenerateStallLink(int index) {
        Point point = new Point(index);
        MoveStill moveStill = new MoveStill();
        Link link = new Link(point, moveStill);
        assertThat(link.to()).isEqualTo(point.move(moveStill));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0x7fffffff})
    void canGenerateLeftLink(int index) {
        Point point = new Point(index);
        MoveLeft moveLeft = new MoveLeft();
        Link link = new Link(point, moveLeft);
        assertThat(link.to()).isEqualTo(point.move(moveLeft));
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void canThrowExceptionOnNegativeLink(int index) {
        Point point = new Point(index);
        MoveLeft moveLeft = new MoveLeft();
        CustomException thrown = assertThrows(CustomException.class, () -> new Link(point, moveLeft));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_POINT_INDEX);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void canGenerateRightLink(int index) {
        Point point = new Point(index);
        MoveRight moveRight = new MoveRight();
        Link link = new Link(point, moveRight);
        assertThat(link.to()).isEqualTo(point.move(moveRight));
    }

    @ParameterizedTest
    @ValueSource(ints = {0x7fffffff})
    void canThrowExceptionOnOverFlow(int index) {
        Point point = new Point(index);
        MoveRight moveRight = new MoveRight();
        CustomException thrown = assertThrows(CustomException.class, () -> new Link(point, moveRight));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_POINT_INDEX);
    }
}
