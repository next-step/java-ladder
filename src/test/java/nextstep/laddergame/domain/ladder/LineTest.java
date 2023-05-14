package nextstep.laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThat(new Line(3))
                .extracting("positions")
                .asList()
                .hasSize(3);
    }

    @Test
    @DisplayName("참여자가 없을경우 exception 발생")
    void emptyParticipants() {
        assertThatThrownBy(() -> new Line(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
