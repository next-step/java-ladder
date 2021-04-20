package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantsTest {

    @Test
    @DisplayName("참가자 미입력")
    void nameIsBlank() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(new ArrayList<>()))
                .withMessageMatching("참가자 정보를 입력해 주세요.");

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
                .withMessageMatching("중복된 참가자가 존재합니다. 참가자명을 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("all 키워드 입력")
    void create_inputAll() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants("pobi,honux,jk,all"))
                .withMessageMatching("all 은 사용할 수 없는 이름입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"sam"})
    @NullAndEmptySource
    @DisplayName("사다리 입구 번호조회 - 존재하지 않는 참가자")
    void getEntranceNumber_noSearch(String participantName) {
        // given
        Participants participants = new Participants("pobi,honux,crong,jk");

        // when then
        assertThrows(NoSuchElementException.class, () -> participants.getEntranceNumber(participantName), participantName + " 은 존재하지 않는 참가자 입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:0", "honux:1", "crong:2", "jk:3"}, delimiter = ':')
    @DisplayName("사다리 입구 번호조회 - 정상 테스트")
    void getEntranceNumber(String participantName, int validationNumber) {
        // given
        Participants participants = new Participants("pobi,honux,crong,jk");

        // when
        int participantNumber = participants.getEntranceNumber(participantName);

        // then
        assertThat(validationNumber).isEqualTo(participantNumber);
    }

}