package nextstep.ladder.domain.tobe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RandomLineCreateStrategyTest: Line 생성 규칙 테스트")
class RandomLineCreateStrategyTest {

    @DisplayName("이전 direction이 RIGHT 였다면 LEFT를 반환")
    @Test
    public void body_WithRIGHT_ReturnLEFT() {
        LineCreateStrategy strategy = new RandomLineCreateStrategy();
        assertThat(strategy.body(Direction.RIGHT)).isEqualTo(Direction.LEFT);
    }

    @DisplayName("이전 direction이 RIGHT 였다면 LEFT를 반환")
    @Test
    public void last_WithRIGHT_ReturnLEFT() {
        LineCreateStrategy strategy = new RandomLineCreateStrategy();
        assertThat(strategy.last(Direction.RIGHT)).isEqualTo(Direction.LEFT);
    }
}
