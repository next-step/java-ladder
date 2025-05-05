package nextstep.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {
    @Test
    @DisplayName("중복된 이름 불가능")
    public void validate() {
        assertThatThrownBy(
            () -> new Participants("pobi, pobi")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자 인덱스 찾기")
    public void participantsIndexTest() {
        Participants participants = new Participants("pobi, brown, honux");
        assertThat(participants.findByName("brown").get().getPosition()).isEqualTo(1);
    }
}
