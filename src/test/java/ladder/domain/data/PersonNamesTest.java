package ladder.domain.data;

import ladder.domain.exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonNamesTest {

    @Test
    void size() {
        PersonNames personNames = new PersonNames(new String[] {"a", "b"});
        assertThat(personNames.size()).isEqualTo(2);
    }

    @Test
    void 중복된_이름() {
        assertThatThrownBy(() -> new PersonNames(new String[] {"a", "a", "b"}))
            .isInstanceOf(LadderException.class)
            .hasMessage("중복된 이름이 있습니다.");
    }
}
