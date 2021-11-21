package nextstep.refactor_ladder.domain;

import nextstep.refactor_ladder.domain.value.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PeopleTest {

    private List<Person> people;

    @BeforeEach
    void setup() {
        people = Arrays.asList(Person.from("pobi"), Person.from("crong"), Person.from("aiden"));
    }

    @Test
    @DisplayName("사람들 목록 정상 생성 검증")
    void create() {
        assertDoesNotThrow(() -> People.from(people));
    }

    @Test
    @DisplayName("정보가 빈값이거나 null인 경우 예외 발생 검증")
    void create_exception() {
        assertAll(() -> {
            assertThatIllegalArgumentException().isThrownBy(() -> People.from(Collections.emptyList()));
            assertThatIllegalArgumentException().isThrownBy(() -> People.from(null));
        });
    }
}
