package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PersonTest {

    private Person person;

    @ParameterizedTest
    @CsvSource(value = {"Craig", "Zig", "Steve"})
    @DisplayName("Person 객체 테스트 : 이름 입력은 정상적으로 되는가?")
    void create_Person_Object_With_Construct(String value) {
        person = Person.valueOf(value);
        assertThat(person.printName()).isEqualTo(value);
    }

    @ParameterizedTest
    @CsvSource(value = {"Kotlin", "Dmitri", "Collation"})
    @DisplayName("Person 객체 예외 테스트 : 5자리 이상의 이름이 입력될 시, Exception 발생하는가?")
    void create_Person_With_Exception_Over_5_Characters(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Person.valueOf(value)
                );
    }
}
