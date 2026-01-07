package nextstep.laddergame;

import static org.junit.jupiter.api.Assertions.assertThrows;
import nextstep.laddergame.domain.Participant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParticipantTest {

    @Test
    void 참가자의_이름이_null이면_에러전파() {
        assertThrows(IllegalArgumentException.class, () -> new Participant(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 참가자의_이름은_0자_혹은_5자이상이면_에러전파(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Participant(name));
    }

}