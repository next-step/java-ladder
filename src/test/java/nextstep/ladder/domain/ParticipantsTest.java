package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    @DisplayName("참석자는 `,` 을 기준으로 split하여, 생성되어야 한다.")
    void createTest() throws NoSuchFieldException, IllegalAccessException {
        String input = "pobi,kiyy,koi,kk";

        Participants participants = Participants.create(input);
        List<Participant> participantList = getParticipantsByReflection(participants);

        List<Participant> expected = Arrays.stream(input.split(","))
            .map(Participant::new)
            .collect(Collectors.toList());

        assertThat(participantList).isEqualTo(expected);
    }

    @Test
    @DisplayName("일급콜렉션 객체의 List는 외부에서는 불변 리스트 이다.")
    void getParticipantsUnmodifiableCollectionTest() {
        String input = "pobi,kiyy,koi,kk";

        Participants participants = Participants.create(input);
        List<Participant> participantsList = participants.getParticipants();

        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> participantsList.add(new Participant("user5")));
    }


    @SuppressWarnings("unchecked")
    private List<Participant> getParticipantsByReflection(Participants participants)
        throws NoSuchFieldException, IllegalAccessException {
        Field participantsField = Participants.class.getDeclaredField("participants");
        participantsField.setAccessible(true);
        return (List<Participant>) participantsField.get(participants);
    }


}