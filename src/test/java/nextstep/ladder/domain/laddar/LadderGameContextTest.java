package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.strategy.DirectionRandomStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.laddar.LadderGameContext.EXCLUDE_FIRST_AND_LAST_COUNT;
import static nextstep.ladder.domain.laddar.LadderGameContext.of;
import static nextstep.ladder.fixture.LadderFixture.HEIGHT_SIZE_FIXTURE;
import static nextstep.ladder.fixture.LadderFixture.WIDTH_SIZE_FIXTURE;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * LadderGameContext는 사다리 게임 설정에 대한 정보를 갖는다.
 */
class LadderGameContextTest {
    private final LadderGameContext ladderGameContext = of(
            LadderSize.of(5, 5),
            DirectionRandomStrategy.getInstance());

    @Test
    @DisplayName("객체 초기화시 생성자 매개변수가 단 하나라도 null이면 즉시 NPE를 발생시킨다.")
    void npe() {
        assertAll(
                () -> Assertions.assertThatThrownBy(() -> {
                    of(null, DirectionRandomStrategy.getInstance());
                }).isInstanceOf(NullPointerException.class),

                () -> Assertions.assertThatThrownBy(() -> {
                    of(LadderSize.of(WIDTH_SIZE_FIXTURE, HEIGHT_SIZE_FIXTURE), null);
                }).isInstanceOf(NullPointerException.class)
        );
    }

    @Test
    void getWidth() {
        Assertions.assertThat(ladderGameContext.getLadderWidth()).isEqualTo(WIDTH_SIZE_FIXTURE);
    }

    @Test
    void getHeight() {
        Assertions.assertThat(ladderGameContext.getLadderHeight()).isEqualTo(HEIGHT_SIZE_FIXTURE);
    }

    @Test
    @DisplayName("처음 열과 마지막 열을 제외한 중간 열의 사이즈를 구한다. 전체 너비에서 처음 열과 마지막 열을 뺀 값(-2)이 중간 열의 사이즈이다.")
    void getMiddleSize() {
        Assertions.assertThat(ladderGameContext.getMiddleColumnSize()).isEqualTo(WIDTH_SIZE_FIXTURE - EXCLUDE_FIRST_AND_LAST_COUNT);
    }

    @Test
    void getDirectionStrategy() {
        Assertions.assertThat(ladderGameContext.getDirectionStrategy())
                  .isInstanceOf(DirectionRandomStrategy.class);
    }
}
