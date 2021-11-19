package nextstep.ladder.domain;

import nextstep.ladder.doamin.People;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.doamin.value.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PeopleTest {

    @Test
    @DisplayName("사람들 목록 정상 생성 검증")
    void create() {
        assertDoesNotThrow(() -> People.from(testPeople()));

    }

    @Test
    @DisplayName("정보가 빈값이거나 null인 경우 예외 발생 검증")
    void create_exception() {
        assertAll(() -> {
            assertThatIllegalArgumentException().isThrownBy(() -> People.from(Collections.emptyList()));
            assertThatIllegalArgumentException().isThrownBy(() -> People.from(null));
        });
    }

    @Test
    @DisplayName("사람들의 수 검증")
    void count() {
        assertThat(People.from(testPeople()).count()).isEqualTo(testPeople().size());
    }


    @ParameterizedTest
    @CsvSource(value = {
            " pobi|     0",
            "crong|     1",
            "aiden|     2"
    }, delimiter = '|')
    @DisplayName("사람의 이름이 몇번째 위치 하는지 확인")
    void getLocation(String name, Integer index) {
        assertThat(People.from(testPeople()).getLocation(Person.from(name))).isEqualTo(Location.from(index));
    }

    @Test
    @DisplayName("사람들 목록에 포함되지 않은 이름인 경우 거짓 반환")
    void isCorrectName() {
        assertThat(People.from(testPeople()).isCorrectName(Person.from("test"))).isFalse();
    }

    private List<Person> testPeople() {
        return Arrays.asList(Person.from("pobi"), Person.from("crong"), Person.from("aiden"));
    }
}
