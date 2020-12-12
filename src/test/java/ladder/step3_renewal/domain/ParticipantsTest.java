package ladder.step3_renewal.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3_renewal.domain.Participants;
import step3_renewal.utils.StringUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantsTest {

    Participants participants;
    List<String> participantList = Arrays.asList("yura", "hih", "ttii", "tm");

    @BeforeEach
    public void setup() {
        participants = Participants.of(participantList);
    }

    @ParameterizedTest
    @DisplayName("입력받은 참가자 정상처리 되었는지 리스트 사이즈 확인")
    @ValueSource(strings = "yu,haha,miii,kii")
    public void 입력받은_참가자_리스트_사이즈확인(String names) {
        assertEquals(Participants.of(StringUtil.splitNames(names)).getParticipants().size(), 4);
    }

    @ParameterizedTest
    @DisplayName("참가자 한명인 경우 예외 확인")
    @ValueSource(strings = {"yura"})
    public void 참가자_한명인_경우(String name) {
        assertThatThrownBy(() ->
                Participants.of(StringUtil.splitNames(name)))
                .hasMessage("참여하는 사람은 최소 2명입니다.");
    }

    @Test
    @DisplayName("입력받은 참가자이름, 위치 확인")
    public void 참가자_이름_위치_확인() {
        participants.getParticipants().stream()
                .map(participant -> participant.getParticipantName() + ":" + participant.getPosition())
                .forEach(System.out::println);
    }
}
