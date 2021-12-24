package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.strategy.Strategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @Test
    @DisplayName("인원 수만큼 가로 라인을 그려서 사다리를 만든다")
    void shouldCreate() {
        Line line = Line.from(4,  new Strategy.Fake());
        assertThat(line).isEqualTo(Line.from(4, new Strategy.Fake()));
    }

    @Test
    @DisplayName("참가자가 없거나 1명이면 IllegalArgumentException을 던진다")
    void shouldThrowWhenInvalidNumberOfParticipants() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.from(1, new Strategy.Fake()));
    }
}