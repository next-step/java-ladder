package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
