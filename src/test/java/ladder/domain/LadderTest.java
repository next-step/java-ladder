package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    Ladder ladder;
    List<Participant> participantList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Participant participant1 = new Participant("name1");
        Participant participant2 = new Participant("name2");
        Participant participant3 = new Participant("name3");
        int height = 5;
        participantList.addAll(List.of(participant1, participant2, participant3));
        ladder = new Ladder(participantList, height);
    }

    @Test
    void initLadderTest() {
        Ladder ladder = new Ladder();
        assertThat(ladder.getClass().getSimpleName()).isEqualTo("Ladder");
    }

    @Test
    void initLadderParticipantTest() {
        assertThat(ladder.getParticipants()).containsAll(participantList);
    }

    @Test
    void getLadderParticipantsNameTest() {
        List<String> expectedList = participantList.stream()
                                            .map(participant -> participant.getName())
                                            .collect(Collectors.toList());

        assertThat(ladder.getParticipantsNames()).containsAll(expectedList);
    }

    @Test
    void initLadderHeightTest() {
        int expectedHeight = 5;
        assertThat(ladder.getHeight()).isEqualTo(expectedHeight);
    }

}
