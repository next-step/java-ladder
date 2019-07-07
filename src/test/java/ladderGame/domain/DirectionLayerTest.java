package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionLayerTest {

    @Test
    @DisplayName("현재 Position에 따른 방향 찾기")
    public void findByPosition() {
        DirectionLayer directionLayer = DirectionLayer.ofGenerator(2, count -> Arrays.asList(Direction.RIGHT, Direction.LEFT));
        Direction direction = directionLayer.getDirectionsByPosition(new Position(0));
        assertThat(direction == Direction.RIGHT).isTrue();
    }

    @Test
    @DisplayName("존재하지 않는 position")
    public void findByPositionException() {
        DirectionLayer directionLayer = DirectionLayer.ofGenerator(2, count -> Arrays.asList(Direction.RIGHT, Direction.LEFT));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            directionLayer.getDirectionsByPosition(new Position(2));
        });
    }

    @Test
    @DisplayName("사다리 게임 룰에 맞지 않는 예외처리")
    public void conflictException1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            DirectionLayer.ofGenerator(2, count -> Arrays.asList(Direction.STRAIGHT, Direction.LEFT));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            DirectionLayer.ofGenerator(2, count -> Arrays.asList(Direction.RIGHT, Direction.STRAIGHT));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            DirectionLayer.ofGenerator(4, count -> Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.LEFT));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            DirectionLayer.ofGenerator(2, count -> Arrays.asList(Direction.RIGHT, Direction.RIGHT));
        });
    }

    @Test
    @DisplayName("참가자 수와 맞지 않는 방향 생성 예외처리")
    public void smallDirectThenNumberOfPlayersException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            DirectionLayer.ofGenerator(5, count -> Arrays.asList(Direction.RIGHT, Direction.STRAIGHT));
        });
    }
}