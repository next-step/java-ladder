package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DotTest {
    @Test
    void create() {
        Dot dot2 = new Dot(false);
        assertFalse(dot2.getValue());
    }
}
