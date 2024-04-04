package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @Test
    @DisplayName("전체 참여자가 1명 이하일 경우에 예외(pobi => IllegalArugmentExcepiton)")
    void exception_when_participant_only_one() {
        assertThatThrownBy(() -> {
            new Participants("pobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자들은 ','를 구분자로 구분(pobi,honux => pobi, honux)")
    void participants_split_by() {
        Participants participant = new Participants("pobi,honux");
        assertThat(participant).isEqualTo(new Participants(List.of(new Participant("pobi"), new Participant("honux"))));
    }

    @Test
    @DisplayName("order 순서에 따라서 참여자들이 다시 재배치된다(a,b,c -> 2,1,0 => c,b,a)")
    void reordering(){
        Participants participants = new Participants(List.of(new Participant("a"), new Participant("b"), new Participant("c")));
        int[] orders = {2, 1, 0};
        assertThat(participants.regenerate(orders)).isEqualTo(new Participants(List.of(new Participant("c"), new Participant("b"), new Participant("a"))));
    }
}
