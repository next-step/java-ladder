package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PeopleTest {

    @Test
    @DisplayName("People 생성")
    void createAndFind() {
        // given
        String peapleName = "hwan,hyun,kook,sun";

        // when
        People people = new People(peapleName);

        // then
        assertThat(people.size()).isEqualTo(4);
        assertThat(people.getPeople().get(0)).isEqualTo(new Person("hwan"));
    }
}