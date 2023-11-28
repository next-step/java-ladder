package ladder.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonNamesTest {

    @Test
    void size() {
        PersonNames personNames = new PersonNames(new String[] {"a", "b"});
        assertThat(personNames.size()).isEqualTo(2);
    }
}
