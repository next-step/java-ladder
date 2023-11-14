package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    void 이름을_생성은_5자를_초과_할_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> new Name("sixsix"));
    }
}
