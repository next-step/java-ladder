package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    Position position;

    @BeforeEach
    void setup() {
        position = new Position(1);
    }

    @Test
    @DisplayName("Direction이 right으로 생성된 Point Move ")
    void rightMove() {
        assertThat(Point.first(true).move(position).getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("Direction이 left으로 생성된 Point Move ")
    void leftMove() {
        assertThat(Point.first(true).next().move(position).getPosition()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("Direction이 Pass으로 생성된 Point Move ")
    void PassMove() {
        assertThat(Point.first(false).move(position).getPosition()).isEqualTo(1);
    }

}
