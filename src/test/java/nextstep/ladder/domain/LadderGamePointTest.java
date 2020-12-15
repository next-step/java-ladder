package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.ForTestStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGamePointTest {

    @DisplayName("첫번째 점 테스트")
    @RepeatedTest(10)
    void firstLadderPointTest() {
        LadderPoint ladderPoint = new LadderPoint(new RandomDirectionStrategy());
        assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막 점 테스트 - left")
    @RepeatedTest(10)
    void lastLadderPointLeftTest() {
        LadderPoint before = new LadderPoint(true, false, new RandomDirectionStrategy());
        LadderPoint ladderPoint = new LadderPoint(before, 2, 3, new RandomDirectionStrategy());
        assertAll(
                () -> assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.LEFT),
                () -> assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.RIGHT)
        );
    }

    @DisplayName("마지막 점 테스트 - right")
    @RepeatedTest(10)
    void lastLadderPointRightTest() {
        LadderPoint before = new LadderPoint(false, true, new RandomDirectionStrategy());
        LadderPoint ladderPoint = new LadderPoint(before, 2, 3, new RandomDirectionStrategy());
        assertAll(
                () -> assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.NONE),
                () -> assertThat(ladderPoint.getDirection()).isNotEqualTo(Direction.RIGHT)
        );
    }

    @DisplayName("다음 점 테스트 - right")
    @Test
    void nextLadderPointRightTest() {
        LadderPoint before = new LadderPoint(true, false, new RandomDirectionStrategy());
        LadderPoint ladderPoint = new LadderPoint(before, 1, 3, new ForTestStrategy(() -> true));
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("다음 점 테스트 - none")
    @Test
    void nextLadderPointNoneTest() {
        LadderPoint before = new LadderPoint(true, false, new RandomDirectionStrategy());
        LadderPoint ladderPoint = new LadderPoint(before, 1, 3, new ForTestStrategy(() -> false));
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.NONE);
    }

    @DisplayName("다음 점 테스트 - left")
    @Test
    void nextLadderPointLeftTest() {
        LadderPoint before = new LadderPoint(false, true, new RandomDirectionStrategy());
        LadderPoint ladderPoint = new LadderPoint(before, 1, 3, new RandomDirectionStrategy());
        assertThat(ladderPoint.getDirection()).isEqualTo(Direction.LEFT);
    }

}
