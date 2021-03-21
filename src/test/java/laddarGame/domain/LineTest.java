package laddarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @DisplayName("가로라인은 중복될 수 없다.")
    @Test
    void isDuplicateHorizontal() {
        assertThrows(IllegalArgumentException.class,
                () -> new Line("LG,SKT,KT", Arrays.asList(true, true, false)));
    }

}