package ladder.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Participants;
import step3.utils.SpliterUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @ParameterizedTest
    @DisplayName("게임결과 확인 : 미참가자 입력시 예외처리")
    @ValueSource(strings = "yu,hh")
    public void 미참가자_예외(String name) {
        assertThatThrownBy(() ->
                Participants.of(SpliterUtil.splitNames(name)).getPoint("hi"))
                .hasMessage("입력하신 참여자를 찾을 수 없습니다. (입력한 참여자 이름: hi)");
    }

    @ParameterizedTest
    @DisplayName("게임결과 확인 : 참가자 처음 위치 확인")
    @ValueSource(strings = "yu,hh")
    public void 참가자_확인(String name) {
        List<String> participants = SpliterUtil.splitNames(name);
        assertThat(Participants.of(participants).getParticipants().get(0).getPosition().getX()).isEqualTo(0);
        assertThat(Participants.of(participants).getParticipants().get(1).getPosition().getX()).isEqualTo(2);
    }
}
