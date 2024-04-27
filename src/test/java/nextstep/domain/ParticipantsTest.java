package nextstep.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParticipantsTest {


    @DisplayName("참가자들을 , 구분자를 이용하여  생성할 수 있다.")
    @Test
    void create() {
        String names = "pobi,honux,crong,jk";
        Participants participants = new Participants(names);
        List<Participant> participantList = participants.getList();
        assertThat(participantList).containsExactly(new Participant("pobi"), new Participant("honux"), new Participant("crong"), new Participant("jk"));
    }
}
