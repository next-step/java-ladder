package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @Test
    void size() {
        List<Name> names = List.of(new Name("apple"));

        assertThat(new Names(names).size()).isEqualTo(names.size());
    }
}
