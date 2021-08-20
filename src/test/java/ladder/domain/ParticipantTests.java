package ladder.domain;

import ladder.exception.InvalidCountOfPersonException;
import ladder.exception.InvalidPersonNameException;
import ladder.exception.NotMatchInParticipantException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipantTests {
    @DisplayName("생성 테스트")
    @Test
    void create() {
        Participant participant = Participant.of(Arrays.asList("pobi", "honux", "crong", "jk"));

        assertThat(participant).isEqualTo(Participant.of(Arrays.asList("pobi", "honux", "crong", "jk")));
    }

    @DisplayName("생성한 사람의 이름이 5글자 넘을 시 Exception 테스트")
    @Test
    void validatePersonName() {
        assertThatExceptionOfType(InvalidPersonNameException.class)
                .isThrownBy(() -> {
                    Participant.of(Arrays.asList("pobi", "honux23344", "crong", "jk"));
                }).withMessageMatching("사람 이름이 5글자를 초과 하였습니다 : honux23344");
    }

    @DisplayName("참가 자의 최소인원이 충족 안됬을 때 Exception 테스트")
    @Test
    void validateCountOfPerson() {
        assertThatExceptionOfType(InvalidCountOfPersonException.class)
                .isThrownBy(() -> {
                    Participant.of(Arrays.asList("pobi"));
                }).withMessageMatching("사다리 게임의 최소 필요 인원은 2명 이상 입니다.");
    }

    @DisplayName("참가자들 로 부터 참가들의 참가한 위치 잘 가져 오는지 확인")
    @Test
    void nameMatchPositionTest() {
        Participant participant = Participant.of(Arrays.asList("pobi", "honux", "crong", "jk"));

        assertThat(participant.getParticipantPosition("crong")).isEqualTo(2);
    }

    @DisplayName("참가자들 로 부터 없는 참가자의 포지션을 요구하면 Exception 확인")
    @Test
    void nameMatchExceptionTest() {
        Participant participant = Participant.of(Arrays.asList("pobi", "honux", "crong", "jk"));

        assertThatExceptionOfType(NotMatchInParticipantException.class)
                .isThrownBy(() -> {
                    participant.getParticipantPosition("syd");
                }).withMessageMatching("참가자 명단에 존재 하지 않습니다. : syd");

    }


}
