package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    @DisplayName("이름이 주어졌을 때 해당 이름으로 participant를 생성하는지 검증")
    @Test
    void constructTest() {
        Name name = new Name("pobi");
        Participant participant = new Participant(name);
        assertThat(participant.name()).isEqualTo(name);
    }

    @DisplayName("문자열 이름이 주어졌을 때 해당 이름으로 participant를 생성하는지 검증")
    @Test
    void factoryMethodTest() {
        String stringName = "pobi";
        Name name = new Name(stringName);
        Participant participant = Participant.from(stringName);
        assertThat(participant.name()).isEqualTo(name);
    }

    @DisplayName("name으로 all이 주어졌을 때 ALL이 맞는지 검증")
    @Test
    void allTest() {
        assertThat(Participant.from("all").isAll()).isTrue();
    }
}
