package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NamesTest {

    @Test
    void testEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Names.of(new String[0]));
    }

    @Test
    void contains() {
        Names names = Names.of(new String[]{"a", "b", "c"});
        assertThat(names.contains(new Name("a"))).isTrue();
        assertThat(names.notContains(new Name("d"))).isTrue();
    }
}
