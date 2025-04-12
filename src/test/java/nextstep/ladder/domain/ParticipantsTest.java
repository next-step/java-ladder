package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {
    @Test
    @DisplayName("기본 생성자와 팩토리 메소드 생성 동작 일치 여부 확인")
    void create() {
        assertThat(Participants.fromNames(List.of(new Name("p1"), new Name("p2"))))
                .isEqualTo(new Participants(List.of(new Participant("p1", 0), new Participant("p2", 1))));
    }

    @Test
    @DisplayName("참여자가 2명 미만인 경우 테스트 - 예외 발생")
    void invalid_name_size() {
        assertThatThrownBy(() -> new Participants(List.of(new Participant("p1"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participants.TOO_FEW_PARTICIPANTS_MESSAGE);
    }

    @Test
    @DisplayName("사다리 결과값과 참가자의 위치 매칭 결과 생성 로직 테스트")
    void match_results() {
        Participants participants = new Participants(
                List.of(
                        new Participant("p1", 1),
                        new Participant("p2", 2),
                        new Participant("p3", 0)
                )
        );
        List<Name> results = List.of(new Name("1000"), new Name("2000"), new Name("3000"));
        Results matchResults = participants.getMatchResults(results);
        System.out.println(matchResults);
        assertThat(matchResults.getResult("p1")).isEqualTo("2000");
        assertThat(matchResults.getResult("p2")).isEqualTo("3000");
        assertThat(matchResults.getResult("p3")).isEqualTo("1000");
    }
}
