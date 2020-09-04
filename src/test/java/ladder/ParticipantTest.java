package ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.domain.Participant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "1,2,3,4,5,6,7,8,9,10"})
    public void playerIndexTest(String names) {

        Participant participant = new Participant(names);

        for (int i = 0; i < participant.getNames().size(); i++) {
            assertEquals(participant.getPlayerIndex(participant.getNames().get(i)), i);
        }
    }
}
