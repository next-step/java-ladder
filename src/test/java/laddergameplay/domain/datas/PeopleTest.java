package laddergameplay.domain.datas;

import laddergameplay.domain.data.Person;
import laddergameplay.domain.datas.People;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PeopleTest {

    @Test
    @DisplayName("People 생성")
    void createAndFind() {
        // given
        String peopleName = "hwan,hyun,kook,sun";
        List<String> peopleList = Arrays.asList(peopleName.split(","));

        // when
        People people = new People(peopleList);

        // then
        assertThat(people).isEqualTo(new People(peopleList));
    }
}