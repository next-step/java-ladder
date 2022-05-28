package nextstep.ladder.doman;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantNamesTest {

    @Test
    void 참가자_이름이_비어있을때() {
        assertThatThrownBy(() -> new ParticipantNames(new ArrayList<>())).isInstanceOf(IllegalArgumentException.class);
    }

}
