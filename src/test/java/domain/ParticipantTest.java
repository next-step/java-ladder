package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ParticipantTest {

    @Test
    @DisplayName("5글자 이하의 이름으로 참여자를 생성할 수 있다.")
    void 참여자_생성() {
        Participant participant = new Participant("pobi2");
        assertThat(participant).isEqualTo(new Participant("pobi2"));
    }

    @Test
    @DisplayName("5글자를 초과하는 이름으로 참여자 생성 시 IllegalArgumentException이 발생한다.")
    void 참여자_이름_초과() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Participant("pobi22"));
    }
}
