package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIllegalArgumentException;

class ParticipantNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 참여자의_이름은_null이거나_빈_문자열일_수_없습니다(String name) {
        IllegalArgumentException e = catchIllegalArgumentException(() -> new ParticipantName(name));
        assertThat(e).hasMessage("참여자의 이름은 null이거나 빈 문자열일 수 없습니다.");
    }

    @Test
    void 참여자의_이름은_5자_이하이어야_합니다() {
        String name = "123456";
        IllegalArgumentException e = catchIllegalArgumentException(() -> new ParticipantName(name));
        assertThat(e).hasMessage("참여자의 이름은 5자 이하이어야 합니다.");
    }
}
