package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPositionTest {


    @Test
    void shouldIncreasePosition(){
        LadderPosition position = new LadderPosition(0);

        position.next();

        assertThat(position.getHorizontalPosition()).isEqualTo(new LadderPosition(1).getHorizontalPosition());
    }

    @Test
    void shouldDecreasePosition(){
        LadderPosition position = new LadderPosition(1);

        position.previous();

        assertThat(position.getHorizontalPosition()).isEqualTo(new LadderPosition(0).getHorizontalPosition());
    }

    @Test
    void shouldValidateArrived(){
        LadderPosition position = new LadderPosition(1);

        position.down();

        assertThat(position.isArrived(new LadderLength(1))).isTrue();
        assertThat(position.isArrived(new LadderLength(2))).isFalse();
    }

}
