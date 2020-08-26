package nextstep.mission;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @Test
    void constructor() {
        assertThat(new Participant("kyd")).isEqualTo(new Participant("kyd"));
    }

    @Test
    void constructorThrow() {
        assertThatThrownBy(() -> new Participant(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Participant("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Participant(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Participant("123456")).isInstanceOf(IllegalArgumentException.class);
    }
}
