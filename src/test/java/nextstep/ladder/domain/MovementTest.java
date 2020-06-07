package nextstep.ladder.domain;

import nextstep.ladder.fake.FakeRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class MovementTest {

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
        Movement movement = Movement.first(movementGenerator);
        assertThat(movement.isLeft()).isFalse();
    }

    @Test
    @DisplayName("movement 생성")
    void createMovementTest() {
        Movement firstMovement = Movement.first(movementGenerator);
        Movement movement = Movement.of(firstMovement, movementGenerator);
        assertThat(firstMovement.isRight()).isEqualTo(movement.isLeft());
    }

    @Test
    @DisplayName("마지막 movement 생성")
    void lastMovementTest() {
        Movement firstMovement = Movement.first(movementGenerator);
        Movement movement = Movement.last(firstMovement);
        assertThat(firstMovement.isRight()).isEqualTo(movement.isLeft());
        assertThat(movement.isRight()).isFalse();
    }

    @Test
    @DisplayName("움직임 테스트")
    void moveTest() {
        Movement firstMovement = Movement.first(trueMovementGenerator);
        Movement lastMovement = Movement.last(firstMovement);
        assertThat(firstMovement.move()).isEqualTo(1);
        assertThat(lastMovement.move()).isEqualTo(-1);
    }

    @Test
    @DisplayName("움직이지 않는 경우 테스트")
    void notMoveTest() {
        Movement firstMovement = Movement.first(falseMovementGenerator);
        Movement lastMovement = Movement.last(firstMovement);
        assertThat(firstMovement.move()).isEqualTo(0);
        assertThat(lastMovement.move()).isEqualTo(0);
    }
}