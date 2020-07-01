package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {

    private Participants defaultParticipants = Participants.of(List.of("pobi", "honux", "crong", "jk"));

    @DisplayName("User들의 statPosition을 얻을 수 있다.")
    @Test
    public void getStartPositionTest() {
        Position startPosition = defaultParticipants.getStartPosition(User.of("pobi"));

        assertThat(startPosition).isEqualTo(Position.of(0));
    }

    @DisplayName("참가자가 아닌 User 일 경우 IllegalArgumet Exception을 발생한다.")
    @Test
    public void getStartPositionNoParticipant() {
        assertThatThrownBy(() -> {
            defaultParticipants.getStartPosition(User.of("pobi2"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사디리 startPosition에 있는 User를 가져 올 수 있다.")
    @Test
    public void getUserTest() {
        User user = defaultParticipants.get(0);

        assertThat(user).isEqualTo(User.of("pobi"));
    }

    @DisplayName("사다리 범위를 벗어나는 startPosition 을 입력하면 IllegalArgument 예외가 발생한다.")
    @Test
    public void getUserOutRange() {
        assertThatThrownBy(() -> {
            defaultParticipants.get(6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 참가자를 가져온다.")
    @Test
    public void getUserAllTest() {
        assertThat(defaultParticipants.getUserAll()).containsOnly(User.of("pobi"), User.of("honux"), User.of("crong"), User.of("jk"));
    }
}
