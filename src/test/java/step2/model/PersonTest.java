package step2.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @ParameterizedTest
    @CsvSource(value = {"Craig", "Zig", "Steve"})
    void create_Person_Object_With_Construct(String value) {
        Person person = new Person(value);
        assertThat(person.printName()).isEqualTo(value);
    }
}
