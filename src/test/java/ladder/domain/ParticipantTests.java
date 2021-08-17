package ladder.domain;

import ladder.exception.InvalidCountOfPersonException;
import ladder.exception.InvalidPersonNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipantTests {
    @DisplayName("생성 테스트")
    @Test
    void create() {
        List<String> participatePersonList = new ArrayList<>(Arrays.asList("pobi", "honux", "crong", "jk"));
        Participant participant = Participant.of(participatePersonList);

        assertThat(participant).isEqualTo(Participant.of(Arrays.asList("pobi", "honux", "crong", "jk")));
    }

    @DisplayName("생성한 사람의 이름이 5글자 넘을 시 Exception 테스트")
    @Test
    void validatePersonName() {
        List<String> participant = new ArrayList<>(Arrays.asList("pobi", "honux23344", "crong", "jk"));

        assertThatExceptionOfType(InvalidPersonNameException.class)
                .isThrownBy(() -> {
                    Participant.of(participant);
                }).withMessageMatching("사람 이름이 5글자를 초과 하였습니다 : honux23344");
    }

    @DisplayName("참가 자의 최소인원이 충족 안됬을 때 Exception 테스트")
    @Test
    void validateCountOfPerson() {
        List<String> participant = new ArrayList<>(Arrays.asList("pobi"));

        assertThatExceptionOfType(InvalidCountOfPersonException.class)
                .isThrownBy(() -> {
                    Participant.of(participant);
                }).withMessageMatching("사다리 게임의 최소 필요 인원은 2명 이상 입니다.");
    }

    @DisplayName("참가자들 로 부터 참가자를 물어봤을때 참가번호를 잘 리턴하는지 테스트")
    @Test
    void participateNumberTest() {
        List<String> participatePersonList = new ArrayList<>(Arrays.asList("pobi", "honux", "crong", "jk"));
        Participant participant = Participant.of(participatePersonList);

        assertThat(participant.getParticipationNumber("crong")).isEqualTo(ParticipateNumber.of(2));
    }



}
