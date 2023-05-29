package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonsTest {

    @Test
    void getPersonsNameTest() {
        var persons = new Persons(new String[]{"AA", "BB"});

        var actualList = persons.getPersonsName();
        var expectList = List.of("AA", "BB");

        assertThat(actualList).isEqualTo(expectList);
    }

    @Test
    void getPersonIndexTest() {
        var persons = new Persons(new String[]{"AA", "BB", "CC", "DD"});

        var actualIndex = persons.getPersonIndex("CC");
        var expectIndex = 2;

        assertThat(actualIndex).isEqualTo(expectIndex);
    }

    @Test
    void getPersonIndexTest_없는이름() {
        var persons = new Persons(new String[]{"AA", "BB", "CC", "DD"});

        assertThatThrownBy(() -> persons.getPersonIndex("GG"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getPersonNameByIndexTest() {
        var persons = new Persons(new String[]{"AA", "BB", "CC", "DD"});

        assertThat(persons.getPersonNameByIndex(3))
                .isEqualTo("DD");
    }
}