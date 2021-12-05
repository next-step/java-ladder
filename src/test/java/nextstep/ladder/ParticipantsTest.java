package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    void create() throws NoSuchFieldException, IllegalAccessException {
        String input = "pobi,kiyy,koi,kk";

        Participants participants = Participants.create(input);
        List<Participant> participantList = getParticipantsByReflection(participants);

        List<Participant> expected = Arrays.stream(input.split(","))
            .map(Participant::new)
            .collect(Collectors.toList());

        assertThat(participantList).isEqualTo(expected);
    }


    @SuppressWarnings("unchecked")
    private List<Participant> getParticipantsByReflection(Participants participants)
        throws NoSuchFieldException, IllegalAccessException {
        Field participantsField = Participants.class.getDeclaredField("participants");
        participantsField.setAccessible(true);
        return (List<Participant>) participantsField.get(participants);
    }


}