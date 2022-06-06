package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantsTest {
    private Participants participants;

    @BeforeEach
    void setUp() {
        String input = "pobi,honux,crong,jk";
        participants = Participants.from(input);
    }

    @DisplayName("문자열 형태의 참여자들 이름을 인자로 받아 Participants 객체를 생성하는 테스트")
    @Test
    void from() {
        assertThat(participants.count()).isEqualTo(4);
    }

    @DisplayName("특정 참여자의 위치를 조회하는 테스트")
    @Test
    void positionOf() {
        System.out.println(participants.positionOf(Participant.from("pobi")).now());
    }

    @DisplayName("존재하지 않는 참여자의 위치를 조회하는 경우 예외 발생 테스트")
    @Test
    void positionOfException() {
        assertThatIllegalArgumentException().isThrownBy(() -> participants.positionOf(Participant.from("fobi")));
    }
}

