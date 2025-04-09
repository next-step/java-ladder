package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeightTest {

    @Test
    public void 양수가_아닌_값_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Height(0));
    }
}
