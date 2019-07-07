package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.util.NamesSplitter;

public class ParticipantsTest {
    @Test
    @DisplayName("Participants는 Participant들을 갖고있는 일급 컬렉션이다.")
    void new_Participants_Created() {
        final List<String> participants = createNames();
        assertThat(new Participants(participants)).isInstanceOf(Participants.class);
    }

    @Test
    @DisplayName("Participants에서 얻은 Participant 리스트는 수정할 수 없다.")
    void getParticipants_Modify_ExceptionThrown() {
        final Participants participants = new Participants(createNames());
        final List<Participant> participantList = participants.getParticipants();

        assertThatThrownBy(() -> participantList.add(new Participant("test")))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    private List<String> createNames() {
        final String input = "pobi,honux,crong,jk";
        return NamesSplitter.split(input);
    }
}
