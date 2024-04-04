package ladder;

import static ladder.Line.MINIMUM_PLAYERS_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    private final ConnectionGenerator connectionGenerator = new RandomConnectionGenerator();

    @Test
    @DisplayName("플레이어 수를 기준으로 사다리의 라인을 생성한다.")
    void Line_PlayersCount() {
        assertThat(Line.from(5, connectionGenerator))
                .isNotNull();
    }

    @Test
    @DisplayName("플레이어 수가 최소 인원 이하인 경우 예외를 던진다.")
    void Line_PlayersCountZero_Exception() {
        final int playersCountLessThanMinimum = MINIMUM_PLAYERS_COUNT - 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.from(playersCountLessThanMinimum, connectionGenerator));
    }
}
