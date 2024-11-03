package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PersonResultsTest {

    @Test
    void 없는_이름이면_예외() {


        PersonResults personResults = new PersonResults(
                List.of(
                        new PersonResult(new Person("java"), new Result("꽝")),
                        new PersonResult(new Person("jeong"), new Result("2000")),
                        new PersonResult(new Person("hyeon"), new Result("3000"))
                )
        );

        assertThatThrownBy(
                () -> personResults.searchName("js")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 서치_사이즈_검증() {
        PersonResults personResults = new PersonResults(
                List.of(
                        new PersonResult(new Person("java"), new Result("꽝")),
                        new PersonResult(new Person("jeong"), new Result("2000")),
                        new PersonResult(new Person("hyeon"), new Result("3000"))
                )
        );

        List<PersonResult> results = personResults.searchName("java");

        assertAll(
                () -> assertThat(results).hasSize(1),
                () -> assertThat(results.get(0)).isEqualTo(
                        new PersonResult(new Person("java"), new Result("꽝"))
                )
        );
    }

    @Test
    void all_search() {
        PersonResults personResults = new PersonResults(
                List.of(
                        new PersonResult(new Person("java"), new Result("꽝")),
                        new PersonResult(new Person("jeong"), new Result("2000")),
                        new PersonResult(new Person("hyeon"), new Result("3000"))
                )
        );
        List<PersonResult> results = personResults.searchName("all");

        assertThat(results).hasSize(3);
    }
}
