package nextstep.ladder;

import nextstep.ladder.domain.Participant;
import nextstep.ladder.exception.ParticipantNameLengthExceedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.*;

public class ParticipantTest {

    @Test
    @DisplayName("[성공] 사람을 생성한다.")
    void 사람_생성() {
        assertThat((new Participant("pobi")).getName()).hasSizeLessThan(Participant.MAX_NAME_LENGTH);
    }

    @Test
    @DisplayName("[실패] 이름 글자수가 초과된 사람을 생성하려는 경우 IllegalUserNameLengthException 예외가 발생한다.")
    void 사람_생성_예외() {
        assertThatExceptionOfType(ParticipantNameLengthExceedException.class)
                .isThrownBy(() -> {
                    new Participant("nayeon");
                }).withMessageContaining(MessageFormat.format("사람의 이름은 {0}글자를 초과할 수 없습니다.", Participant.MAX_NAME_LENGTH));
    }
}
