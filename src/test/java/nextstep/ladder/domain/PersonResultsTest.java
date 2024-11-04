package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonResultsTest {

    @Test
    void 없는_이름이면_예외() {

        Map<Person, Result> map = new LinkedHashMap<>();
        map.put(new Person("java"), new Result("꽝"));
        map.put(new Person("jeong"), new Result("2000"));
        map.put(new Person("hyeon"), new Result("3000"));
        PersonResults personResults = new PersonResults(map);

        assertThatIllegalArgumentException().isThrownBy(
                () -> personResults.getResultByPerson(new Person("js"))
        );

    }

    @Test
    void 서치() {
        Map<Person, Result> map = new LinkedHashMap<>();
        map.put(new Person("java"), new Result("꽝"));
        map.put(new Person("jeong"), new Result("2000"));
        map.put(new Person("hyeon"), new Result("3000"));
        PersonResults personResults = new PersonResults(map);

        Result result = personResults.getResultByPerson(new Person("java"));

        assertThat(result).isEqualTo(new Result("꽝"));
    }

    @Test
    void key_list() {
        Map<Person, Result> map = new LinkedHashMap<>();
        map.put(new Person("java"), new Result("꽝"));
        map.put(new Person("jeong"), new Result("2000"));
        map.put(new Person("hyeon"), new Result("3000"));
        PersonResults personResults = new PersonResults(map);

        List<Person> keys = personResults.getKeys();

        assertThat(keys).isEqualTo(List.of(new Person("java"), new Person("jeong"), new Person("hyeon")));
    }

}
