package ladder.gilbert.domain.data;

import ladder.gilbert.domain.exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonsTest {

    @Test
    void 중복된_사람() {
        assertThatThrownBy(() -> new Persons(new String[] {"a", "a", "b"}))
            .isInstanceOf(LadderException.class)
            .hasMessage("중복된 사람이 있습니다.");
    }

    @Test
    void 사람_순서_찾기() {
        Person person = new Person("b");
        assertThat(persons().toOrder(person)).isEqualTo(1);
    }

    @Test
    void 게임에_참여하지_않은_사람_결과_조회() {
        assertThatThrownBy(() -> persons().toOrder(new Person("d")))
            .isInstanceOf(LadderException.class)
            .hasMessage("게임에 참여한 사람의 결과만 볼 수 있습니다.");
    }

    @Test
    void size() {
        Persons persons = persons();
        assertThat(persons.size()).isEqualTo(3);
    }

    private Persons persons() {
        return new Persons(new String[] {"a", "b", "c"});
    }
}
