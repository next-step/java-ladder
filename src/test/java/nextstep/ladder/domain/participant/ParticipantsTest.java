package nextstep.ladder.domain.participant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

    private Participants participants;

    @BeforeEach
    void setUp() {
        List<Participant> participantsList = Arrays.asList(
                new Participant("pobi"),
                new Participant("honux"),
                new Participant("crong"),
                new Participant("jk")
        );

        participants = new Participants(participantsList);
    }


    @Test
    @DisplayName("사이즈 테스트")
    void size() {
        assertEquals(4, participants.size());
    }
}