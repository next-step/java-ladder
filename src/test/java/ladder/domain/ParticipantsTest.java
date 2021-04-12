package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {

    @Test
    @DisplayName("참가자명 미입력")
    void nameIsBlank() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(null))
                .withMessageMatching("참가자 이름을 입력해 주세요.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(" "))
                .withMessageMatching("참가자 이름을 입력해 주세요.");
    }

    @Test
    @DisplayName("참가자 이름 목록 중 미입력 건 존재")
    void namesWithBlank() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants("pobi,,,jk"))
                .withMessageMatching("참가자 이름을 입력해 주세요.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants("pobi,   ,crong,jk"))
                .withMessageMatching("참가자 이름을 입력해 주세요.");
    }

    @Test
    @DisplayName("참가자 이름 목록 중 최대입력길이 초과 건 존재")
    void nameWithMaxLength() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants("pobi,limdingdong,jk"))
                .withMessageMatching("참가자 이름은 최대 5글자까지 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("참가자 정상생성 - 참가자 수 확인")
    void create_participantCount() {
        // given when
        Participants participants = new Participants("pobi,honux,crong,jk");

        // then
        assertThat(4).isEqualTo(participants.getCount());
    }

    @Test
    @DisplayName("참가자 정상생성 - 참가자 명 확인")
    void create_participantNames() {
        // given when
        String participantNames = "pobi,honux,crong,jk";
        Participants participants = new Participants(participantNames);

        // then
        for (Participant participant : participants.getParticipants()) {
            boolean present = Arrays.stream(participantNames.split(",")).anyMatch(participantName -> participantName.equals(participant.getName()));
            assertThat(present).isTrue();
        }
    }

    @Test
    @DisplayName("중복된 이름 입력")
    void create_duplicatedNames() {
        // given
        String participantNames = "pobi,honux,jk,jk";

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(participantNames))
                .withMessageMatching("중복된 이름이 존재합니다. 참가자명을 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("all 키워드 입력")
    void create_inputAll() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants("pobi,honux,jk,all"))
                .withMessageMatching("all 은 사용할 수 없는 이름입니다.");
    }

}