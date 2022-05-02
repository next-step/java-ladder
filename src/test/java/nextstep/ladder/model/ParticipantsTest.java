package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("참여자들")
class ParticipantsTest {

    @Test
    @DisplayName("문자열들로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Participants.from(Arrays.asList("a", "b")));
    }

    @Test
    @DisplayName("문자열들은 필수")
    void instance_nullStringsProvider_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Participants.from(null));
    }

    @Test
    @DisplayName("참여자는 2명 이상")
    void instance_lessThanTwo_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Participants.from(Collections.singletonList("a")));
    }

    @Test
    @DisplayName("주어진 문자열들로 사이즈 반환")
    void size() {
        assertThat(Participants.from(Arrays.asList("a", "b", "c")).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("주어지는 문자열들로 참가자 반환")
    void list() {
        assertThat(Participants.from(Arrays.asList("a", "b", "c")).list()).containsExactly(Participant.from("a"), Participant.from("b"), Participant.from("c"));
    }

    @Test
    @DisplayName("존재하지 않음")
    void isNotExist() {
        //given
        Participants participants = Participants.from(Arrays.asList("a", "b"));
        //when, then
        assertThat(participants.isNotExist(Participant.from("a"))).isFalse();
        assertThat(participants.isNotExist(Participant.from("c"))).isTrue();
    }

    @Test
    @DisplayName("인덱스 정보")
    void indexOf() {
        //given
        Participants participants = Participants.from(Arrays.asList("a", "b"));
        //when, then
        assertThat(participants.indexOf(Participant.from("a"))).isZero();
        assertThat(participants.indexOf(Participant.from("c"))).isEqualTo(-1);
    }
}
