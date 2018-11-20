package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private final boolean TRUE = true;
    private final boolean FALSE = false;

    @Test
    public void 왼쪽으로_움직임_테스트() {
        Position position = new Position(1, DirectionType.mathDirectionType(TRUE, FALSE));
        int result = position.move();
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 오른쪽으로_움직임_테스트() {
        Position position = new Position(1, DirectionType.mathDirectionType(FALSE, TRUE));
        int result = position.move();
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 첫번째_줄_생성_테스트() {
        Position position = Position.generateFirstPosition(TRUE);
        boolean result =  position.getDirection().isLeft();
        assertThat(result).isEqualTo(FALSE);
    }

    @Test
    public void 마지막_줄_생성_테스트() {
        Position position = new Position(1, DirectionType.mathDirectionType(FALSE, TRUE));
        boolean result2 = Position.generateLastPosition(position).getDirection().isRight();
        assertThat(result2).isEqualTo(FALSE);
    }
}