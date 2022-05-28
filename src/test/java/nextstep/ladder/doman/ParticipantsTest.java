package nextstep.ladder.doman;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @Test
    void 참가자_이름이_없을때() {
        assertThatThrownBy(() -> new Participants(new ArrayList<>())).isInstanceOf(IllegalArgumentException.class);
    }

}
