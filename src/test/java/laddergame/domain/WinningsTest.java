package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningsTest {
    @Nested
    @DisplayName("Winnings 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @Test
        @DisplayName("인스턴스 생성시 winnings의 크기가 WINNINGS_MIN_NUMBER보다 작은 경우 IllegalArgumentException이 발생한다.")
        void testWrongSizeOfPlayers() {
            List<Winning> winnings = List.of(Winning.valueOf("1000"));
            assertThatThrownBy(() -> Winnings.valueOf(winnings))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }
}