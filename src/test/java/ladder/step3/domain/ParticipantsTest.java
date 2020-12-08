package ladder.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Participants;
import step3.utils.SpliterUtil;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantsTest {
    @ParameterizedTest
    @DisplayName("입력받은 참가자 정상처리 되었는지 리스트 사이즈 확인")
    @ValueSource(strings = "yu,haha,miii,kii")
    public void 입력받은_참가자_리스트_사이즈확인(String names) {
        assertEquals(Participants.of(SpliterUtil.splitNames(names)).getParticipants().size(), 4);
    }

    @ParameterizedTest
    @DisplayName("참가자 한명인 경우 예외 확인")
    @ValueSource(strings = {"yura"})
    public void 참가자_한명인_경우(String name) {
        assertThatThrownBy(() ->
                Participants.of(SpliterUtil.splitNames(name)))
                .hasMessage("참여하는 사람은 최소 2명입니다.");
    }
}
