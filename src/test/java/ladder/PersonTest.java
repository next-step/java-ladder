package ladder;

import ladder.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonTest {

    @Test
    void Person_객체_생성() {
        String name = "java";
        Person person = new Person(name, 0);

        assertThat(person.getName()).isEqualTo(name);
        assertThat(person.getPosition()).isEqualTo(0);
    }

    @Test
    void 이름_길이_예외() {
        String nameOver = "player";

        assertThatThrownBy(() -> new Person(nameOver, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_이동() {
        Person test = new Person("test", 1);
        List<Boolean> lineCondition = Arrays.asList(true, false);
        int movedResult = test.move(lineCondition);

        assertThat(movedResult).isEqualTo(0);
    }
}