package nextstep.ladder.domain;

import nextstep.ladder.fake.FakeRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    private MovementGenerator movementGenerator;
    private MovementGenerator trueMovementGenerator;
    private MovementGenerator falseMovementGenerator;

    @BeforeEach
    void setup() {
        this.movementGenerator = new RandomMovementGenerator(new Random());
        this.trueMovementGenerator = new RandomMovementGenerator(new FakeRandom(true));
        this.falseMovementGenerator = new RandomMovementGenerator(new FakeRandom(false));
    }

    @Test
    @DisplayName("첫번째 movement 생성")
    void firstMovementTest() {
        Direction direction = Direction.first(movementGenerator);
        assertThat(direction.isLeft()).isFalse();
    }

    @Test
    @DisplayName("movement 생성")
    void createMovementTest() {
        Direction firstDirection = Direction.first(movementGenerator);
        Direction direction = Direction.of(firstDirection, movementGenerator);
        assertThat(firstDirection.isRight()).isEqualTo(direction.isLeft());
    }

    @Test
    @DisplayName("마지막 movement 생성")
    void lastMovementTest() {
        Direction firstDirection = Direction.first(movementGenerator);
        Direction direction = Direction.last(firstDirection);
        assertThat(firstDirection.isRight()).isEqualTo(direction.isLeft());
        assertThat(direction.isRight()).isFalse();
    }

    @Test
    @DisplayName("움직임 테스트")
    void moveTest() {
        Direction firstDirection = Direction.first(trueMovementGenerator);
        Direction lastDirection = Direction.last(firstDirection);
        assertThat(firstDirection.move()).isEqualTo(1);
        assertThat(lastDirection.move()).isEqualTo(-1);
    }

    @Test
    @DisplayName("움직이지 않는 경우 테스트")
    void notMoveTest() {
        Direction firstDirection = Direction.first(falseMovementGenerator);
        Direction lastDirection = Direction.last(firstDirection);
        assertThat(firstDirection.move()).isEqualTo(0);
        assertThat(lastDirection.move()).isEqualTo(0);
    }
}