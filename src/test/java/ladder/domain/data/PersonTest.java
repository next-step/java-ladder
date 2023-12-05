package ladder.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    void hasAll() {
        assertThat(new Person("all").hasAll()).isTrue();
    }

}
