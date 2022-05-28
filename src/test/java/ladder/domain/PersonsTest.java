package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PersonsTest {
    public static final Person pobi = Person.of("pobi");
    public static final Person honux = Person.of("honux");

    @Test
    void create() {
        Persons persons = Persons.of(Arrays.asList(pobi, honux));
        assertThat(persons).isEqualTo(Persons.of(Arrays.asList(pobi, honux)));
    }
}
