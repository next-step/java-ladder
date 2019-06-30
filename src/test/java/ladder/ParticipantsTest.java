package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    @DisplayName("이름 리스트로 인스턴스를 생설 할 수 있다")
    void ofList() {
        List<String> nameList = Arrays.asList("1,2");
        List<Participant> participantList = new ArrayList<>();
        participantList.add(new Participant("1"));
        participantList.add(new Participant("2"));

        Participants participants = Participants.of(nameList);
        assertThat(participants).isEqualTo(participantList);
    }
}
