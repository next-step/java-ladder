package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParticipantsTest {

    @Test
    void create() {
        Participants participants = Participants.create("aaa,bbb,ccc");
        assertThat(participants.getParticipantCount()).isEqualTo(3);
    }

    @Test
    @DisplayName(value = "최소 두명의 사람이 필요함.")
    void isLessThanTwoPeople() {
        assertThatThrownBy(() -> Participants.create("aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(value = "유저를 찾아서 반환함.")
    void findPerson() {
        Participants participants = Participants.create("aaa,bbb,ccc");
        assertThat(participants.findPerson("aaa").getName()).isEqualTo("aaa");
    }

    @Test
    @DisplayName(value = "유저를 찾아서 반환함. 유저가 없으면 IllegalArgumentException 발생.")
    void findPersonWithException() {
        Participants participants = Participants.create("aaa,bbb,ccc");

        assertThatThrownBy(() -> participants.findPerson("ddd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
