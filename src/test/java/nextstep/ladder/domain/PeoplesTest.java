package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PeoplesTest {
    private Peoples peoples;

    @BeforeEach
    void setUp() {
        String peopleString = "pobi,honux,crong,jk";
        peoples = Peoples.of(peopleString);
    }

    @Test
    @DisplayName("참여 인원 string으로 Peoples 객체를 생성하는지 테스트")
    void parse() {
        assertThat(peoples.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("index로 참여인원을 갖고오는지 확인한다.")
    void getPeople() {
        People expectedPeople = new People("pobi");
        assertThat(peoples.peopleByIndex(0)).isEqualTo(expectedPeople);
    }

    @Test
    @DisplayName("입력받은 이름에 따른 Peoples를 리턴 하는지 확인")
    void getPeoplesByResultName() {
        Peoples allPeoples = peoples.getResultPeoples("all");
        assertThat(allPeoples.size()).isEqualTo(4);
        for (int i = 0; i < peoples.size(); i++) {
            assertThat(peoples.peopleByIndex(i).toString()).isIn("pobi", "honux", "crong", "jk");
        }

        Peoples pobi = peoples.getResultPeoples("pobi");
        assertThat(pobi.size()).isEqualTo(1);
        for (int i = 0; i < pobi.size(); i++) {
            assertThat(pobi.peopleByIndex(i).toString()).isEqualTo("pobi");
        }
    }

    @Test
    @DisplayName("참여 명단에 없는 이름에 따른 에러를 발생 하는지 확이 ")
    void getPeoplesByResultNameNoSuch() {
        assertThatThrownBy(() -> {
            peoples.getResultPeoples("test");
        }).isInstanceOf(NoSuchElementException.class);
    }
}
