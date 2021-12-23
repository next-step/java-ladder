package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @Test
    @DisplayName("인원 수만큼 가로 라인을 그려서 사다리를 만든다")
    void shouldCreate() {
        List<Boolean> inputs = Arrays.asList(true, false);
        Line line = Line.from(2, numberOfParticipants -> inputs);
        assertThat(line).isEqualTo(Line.from(2, numberOfParticipants -> inputs));
    }

    @Test
    @DisplayName("참가자가 없거나 1명이면 IllegalArgumentException을 던진다")
    void shouldThrowWhenInvalidNumberOfParticipants() {
        List<Boolean> inputs = Arrays.asList(true, false);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.from(1, numberOfParticipants -> inputs));
    }
}