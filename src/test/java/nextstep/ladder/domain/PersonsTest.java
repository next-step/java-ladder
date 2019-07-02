package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class PersonsTest {

    @Test
    void create() {
        List<String> personNames = Arrays.asList("pobi", "honux", "crong", "jk");
        new Persons(personNames);
    }

    @Test
    void 동일이름을_입력한경우_중복제거() {
        List<String> personNames = Arrays.asList("pobi", "honux", "crong", "jk", "jk");
        Persons persons = new Persons(personNames);

        assertThat(persons.size()).isEqualTo(personNames.size() - 1);
    }
}
