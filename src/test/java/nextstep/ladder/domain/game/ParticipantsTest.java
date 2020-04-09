package nextstep.ladder.domain.game;

import nextstep.ladder.domain.game.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @DisplayName("참가자 이름을 저장하는 컬렉션을 생성한다.")
    @Test
    void create() {
        List<String> names = Arrays.asList("boram", "luvra", "rambo");
        Participants participants = new Participants(names);
        assertThat(participants.size()).isEqualTo(3);
    }
}
