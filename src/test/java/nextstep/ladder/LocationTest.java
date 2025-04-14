package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocationTest {

    @Test
    public void 음수_값_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Location(-1));
    }
}
