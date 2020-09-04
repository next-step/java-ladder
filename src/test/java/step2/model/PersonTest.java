package step2.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PersonTest {

    private Person person;

    @ParameterizedTest
    @CsvSource(value = {"Craig", "Zig", "Steve"})
    void create_Person_Object_With_Construct(String value) {
        person = new Person(value);
        assertThat(person.printName()).isEqualTo(value);
    }

    @ParameterizedTest
    @CsvSource(value = {"Kotlin", "Dmitri", "Collation"})
    void create_Person_With_Exception_Over_5_Characters(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Person(value)
                );
    }
}
