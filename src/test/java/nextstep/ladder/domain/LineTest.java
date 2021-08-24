package nextstep.ladder.domain;

import nextstep.ladder.dto.LineBarStatusDto;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LineTest {

    @Test
    @DisplayName("Line 생성 - playerCount 값이 0보다 작은 경우")
    public void lessThanZeroPlayerCount() {
        // given
        int playerCount = -1;
        String message = String.format("playerCount 값은 0보다 작을 수 없습니다 -> %d", playerCount);

        // when
        ThrowingCallable throwingCallable = () -> new Line(playerCount);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getBarInstalledStatus 테스트")
    public void getBarInstalledStatus() {
        // given
        Line line = new Line(4);
        int expected = 3;

        // when
        LineBarStatusDto barInstalledStatus = line.getLineBarStatus();
        int size = barInstalledStatus.getBarStatus()
                .size();

        // then
        assertThat(size).isEqualTo(expected);
        assertThat(isContinuesBarInstalled(barInstalledStatus)).isEqualTo(false);
    }

    private boolean isContinuesBarInstalled(final LineBarStatusDto barInstalledStatus) {
        AtomicBoolean prevBar = new AtomicBoolean(false);
        return barInstalledStatus.getBarStatus()
                .stream()
                .anyMatch(barInstalled -> prevBar.getAndSet(barInstalled) && barInstalled);
    }

}