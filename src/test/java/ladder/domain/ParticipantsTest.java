package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이름 일급 컬렉션 테스트")
class ParticipantsTest {

    @DisplayName("문자열에 유효한 구분자(콤마)가 포함되어 있지 않으면 예외가 발생한다")
    @Test
    void invalidDelimiterTest() {
        String inputNames = "korea japan china";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(inputNames))
                .withMessage("유효한 구분자가 포함되어 있지 않습니다");
    }

    @DisplayName("참여 인원은 1명보다 많아야 한다")
    @Test
    void invalidParticipantsTest() {
        String inputNames = " , ";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(inputNames))
                .withMessage("참여 인원은 1명 보다 많아야 합니다");
    }

    @DisplayName("문자열에 유효한 구분자(콤마)가 포함되어 있으면 정상적으로 이름 컬렉션을 생성한다")
    @Test
    void validInputNames() {
        String inputNames = "korea,japan,china";
        Participants participants = new Participants(inputNames);
        Assertions.assertThat(participants.fetchNames()).size().isEqualTo(3);
    }

    @DisplayName("참여 이름 문자열을 공백과 함께 중앙 정렬 할수 있다")
    @Test
    void centerAlignedParticipantNamesTest() {
        String inputNames = "aaa,bbb,ccc";
        Participants participants = new Participants(inputNames);
        String centerAlignedParticipantNames = participants.centerAlignedParticipantNames(10);
        Assertions.assertThat(centerAlignedParticipantNames).isEqualTo("   aaa        bbb        ccc    ");
    }
}

