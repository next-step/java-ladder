package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private RightDirection rightDirection;
    @BeforeEach
    void setUp() {
        rightDirection = () -> true;
    }

    @DisplayName("입력받은 높이만큼의 사다리가 만들어진다.")
    @Test
    void height() {
        int height = 5;
        int width = 4;
        Ladder ladder = new Ladder(width, height, rightDirection);
        assertThat(ladder.height()).isEqualTo(height);
    }

    @DisplayName("세로 라인에는 하나 이상의 오른쪽 선이 있어야 한다.")
    @Test
    void rightDirection() {
        int height = 5;
        int width = 4;
        RightDirection rightDirection = () -> false;
        Ladder ladder = new Ladder(width, height, rightDirection);

        boolean hasRightDirection = ladder.vertical(0).stream()
                .anyMatch(Point::hasRightDirection);

        assertThat(hasRightDirection).isTrue();
    }
}
