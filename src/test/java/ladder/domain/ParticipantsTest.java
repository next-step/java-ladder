package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantsTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "1,2,3,4,5,6,7,8,9,10"})
    public void playerIndexTest(String names) {

        Participants participants = new Participants(names);

        for (int i = 0; i < participants.getNames().size(); i++) {
            assertEquals(participants.getPlayerIndex(participants.getNames().get(i)), i);
        }
    }
}
