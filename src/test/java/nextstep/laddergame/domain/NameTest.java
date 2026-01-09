package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import nextstep.laddergame.domain.participant.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @Test
    void 참가자의_이름이_null이면_에러전파() {
        assertThrows(IllegalArgumentException.class, () -> new Name(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 참가자의_이름은_0자_혹은_5자이상이면_에러전파(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }
}