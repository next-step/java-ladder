package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @Test
    @DisplayName("전체 참여자가 1명 이하일 경우에 예외(pobi => IllegalArugmentExcepiton)")
    void exception_when_participant_only_one() {
        assertThatThrownBy(() -> {
            new Participant("pobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자들은 ','를 구분자로 구분(pobi,honux => pobi, honux)")
    void participants_split_by() {
        Participant participant = new Participant("pobi,honux");
        assertThat(participant).isEqualTo(new Participant(List.of(new Name("pobi"), new Name("honux"))));
    }
}
