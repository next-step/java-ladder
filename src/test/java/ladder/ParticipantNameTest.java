package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParticipantNameTest {

    @Test
    void 생성() {
        ParticipantName julia = new ParticipantName("julia");
        assertThat(julia).isEqualTo(new ParticipantName("julia"));
    }

    @Test
    void 이름이_5글자가_넘으면_Exception이_발생한다() {
        assertThatThrownBy(() -> new ParticipantName("testtest"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("name is too long");
    }
}
