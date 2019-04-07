import domain.Participants;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ParticipantsTest {

    @Test
    public void participantsInit() {
        Participants participants = new Participants(Arrays.asList("mario","yoshi","luigi"));
        assertEquals(3, participants.getNumber());
    }
}
