package ladder;

import ladder.domain.GameAttendees;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameAttendeesTest {
    GameAttendees gameAttendees = new GameAttendees("hello,world,test");

    @ParameterizedTest
    @DisplayName("유효하지 않은 인덱스의 참석자를 부를 경우 실패")
    @ValueSource(ints = {3, 4, 5})
    void FailIfGetAttendeesIndexInvalid(int input) {
        assertThatThrownBy(() -> gameAttendees.getGameAttendees(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 참석자의 수가 실제 입력과 같은지 확인")
    void IsNumberOfAttendeesSizeEqualWithInput() {
        int actual = gameAttendees.getNumberOfGameAttendees();

        assertThat(actual).isEqualTo(3);
    }
}
