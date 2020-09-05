package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사람")
public class PersonTest {

    @DisplayName("생성")
    @Test
    public void create() {
        Person expect = new Person("test");
        Person actual = new Person("test");
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("이름 밸리데이션 - 최대5글자")
    @ParameterizedTest
    @CsvSource(value = { ",false", "  ,false", "이주영,true", "이주영1123,false" })
    public void validateName(String name, Boolean result) {
        assertThat(Person.validateName(name)).isEqualTo(result);
    }

}
