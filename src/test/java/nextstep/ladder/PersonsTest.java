package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonsTest {

    @Test
    void getPersonsNameTest() {
        var persons = new Persons(new String[]{"AA", "BB"});

        var actualList = persons.getPersonsName();
        var expectList = List.of("AA", "BB");

        assertThat(actualList).isEqualTo(expectList);
    }
}