package ladder.domain;

import ladder.domain.ladder.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderSizeTest {
    @DisplayName("게임 참가자 수, 사다리 높이 값을 받아 생성된다.")
    @Test
    void create() {
        assertThat(new LadderSize(1, 1)).isNotNull();
    }

    @DisplayName("참가자 수 혹은 사다리 높이가 1 미만이면 Exception 발생한다.")
    @ParameterizedTest(name = "{arguments} {displayName}")
    @CsvSource({"0, 1", "1, 0", "0, 0"})
    void validate(int countOfParticipants, int ladderHeight) {
        assertThatThrownBy(() -> new LadderSize(countOfParticipants, ladderHeight)).isInstanceOf(RuntimeException.class);
    }
}
