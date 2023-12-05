package ladder.domain.data;

import ladder.domain.exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonsTest {

    @Test
    void size() {
        Persons persons = persons();
        assertThat(persons.size()).isEqualTo(3);
    }

    @Test
    void 중복된_사람() {
        assertThatThrownBy(() -> new Persons(new String[] {"a", "a", "b"}))
            .isInstanceOf(LadderException.class)
            .hasMessage("중복된 사람이 있습니다.");
    }

    @Test
    void 같은_사람_찾기() {
        Person person = new Person("b");
        assertThat(persons().find(person)).isEqualTo(person);
    }

    @Test
    void 게임에_참여하지_않은_사람_결과_조회() {
        assertThatThrownBy(() -> persons().find(new Person("d")))
            .isInstanceOf(LadderException.class)
            .hasMessage("게임에 참여한 사람의 결과만 볼 수 있습니다.");
    }

    private Persons persons() {
        return new Persons(new String[] {"a", "b", "c"});
    }
}
