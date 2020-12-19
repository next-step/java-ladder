package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.ForTestStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGamePointTest {

    @DisplayName("첫번째 포인트 테스트 - right")
    @Test
    public void firstPointRightTest() {
        LadderPoint ladderPoint = LadderPoint.generateFirst(new ForTestStrategy(() -> true));
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("첫번째 포인트 테스트 - none")
    @Test
    public void firstPointNoneTest() {
        LadderPoint ladderPoint = LadderPoint.generateFirst(new ForTestStrategy(() -> false));
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.NONE);
    }

    @DisplayName("다음점 포인트 테스트 - left")
    @Test
    public void nextPointLeftTest() {
        LadderPoint beforeLadderPoint = new LadderPoint(Direction.RIGHT);
        LadderPoint ladderPoint = LadderPoint.generateNext(beforeLadderPoint, new ForTestStrategy(() -> false));
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("다음점 포인트 테스트 - right")
    @Test
    public void nextPointNoneRightTest() {
        LadderPoint beforeLadderPoint = new LadderPoint(Direction.NONE);
        LadderPoint ladderPoint = LadderPoint.generateNext(beforeLadderPoint, new ForTestStrategy(() -> true));
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("다음점 포인트 테스트 - none")
    @Test
    public void nextPointNoneNoneTest() {
        LadderPoint beforeLadderPoint = new LadderPoint(Direction.NONE);
        LadderPoint ladderPoint = LadderPoint.generateNext(beforeLadderPoint, new ForTestStrategy(() -> false));
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.NONE);
    }

    @DisplayName("다음점 포인트 테스트 - right")
    @Test
    public void nextPointLeftRightTest() {
        LadderPoint beforeLadderPoint = new LadderPoint(Direction.LEFT);
        LadderPoint ladderPoint = LadderPoint.generateNext(beforeLadderPoint, new ForTestStrategy(() -> true));
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("다음점 포인트 테스트 - none")
    @Test
    public void nextPointLeftNoneTest() {
        LadderPoint beforeLadderPoint = new LadderPoint(Direction.LEFT);
        LadderPoint ladderPoint = LadderPoint.generateNext(beforeLadderPoint, new ForTestStrategy(() -> false));
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.NONE);
    }

    @DisplayName("마지막 포인트 테스트 - left")
    @Test
    public void lastPointLeftTest() {
        LadderPoint beforeLadderPoint = new LadderPoint(Direction.RIGHT);

        LadderPoint ladderPoint = LadderPoint.generateLast(beforeLadderPoint);
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막 포인트 테스트 - none")
    @Test
    public void lastPointNoneTest() {
        LadderPoint beforeLadderPoint = new LadderPoint(Direction.LEFT);

        LadderPoint ladderPoint = LadderPoint.generateLast(beforeLadderPoint);
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.NONE);
    }

}
