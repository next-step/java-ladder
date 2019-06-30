package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    @DisplayName("이름 리스트로 인스턴스를 생설 할 수 있다")
    void ofList() {
        Names names = new Names(Arrays.asList("1,2"));
        List<Participant> participantList = names.getNames().stream()
                .map(Participant::new)
                .collect(Collectors.toList());

        Participants participants = Participants.of(names);
        assertThat(participants.getParticipants()).isEqualTo(participantList);
    }
}
