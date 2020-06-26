package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {

    @DisplayName("User들의 statPosition을 얻을 수 있다.")
    @Test
    public void getStartPositionTest() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(LadderHeight.of(3), users.size());
        Participants participants = Participants.of(users, ladder);

        int startPosition = participants.getStartPosition(User.of("pobi"));

        assertThat(startPosition).isEqualTo(0);
    }

    @DisplayName("참가자가 아닌 User 일 경우 IllegalArgumet Exception을 발생한다.")
    @Test
    public void getStartPositionNoParticipant() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(LadderHeight.of(3), users.size());
        Participants participants = Participants.of(users, ladder);

        assertThatThrownBy(() -> {
            participants.getStartPosition(User.of("pobi2"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 User가 ladder의 크기가 다르면 IllegalArgumentException 을 발생한다.")
    @Test
    public void differntUserCountAndLadderStartPositionCount() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(LadderHeight.of(3), 3);

        assertThatThrownBy(() -> {
            Participants.of(users, ladder);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사디리 startPosition에 있는 User를 가져 올 수 있다.")
    @Test
    public void getUserTest() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(LadderHeight.of(3), 4);
        Participants participants = Participants.of(users, ladder);

        User user = participants.get(0);

        assertThat(user).isEqualTo(users.get(0));
    }

    @DisplayName("사다리 범위를 벗어나는 startPosition 을 입력하면 IllegalArgument 예외가 발생한다.")
    @Test
    public void getUserOutRange() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(LadderHeight.of(4), 4);
        Participants participants = Participants.of(users, ladder);

        assertThatThrownBy(() -> {
            participants.get(6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 참가자를 가져온다.")
    @Test
    public void getUserAllTest() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(LadderHeight.of(4), 4);
        Participants participants = Participants.of(users, ladder);

        assertThat(participants.getUserAll()).containsAll(users);
    }
}
