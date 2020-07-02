package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    private Participants defaultParticipants;
    private Ladder defaultLadder;
    private LadderGame defaultLadderGame;

    @BeforeEach
    public void setup() {
        defaultParticipants = Participants.of(List.of("pobi", "honux", "crong", "jk"));
        defaultLadder = new Ladder(LadderHeight.of(3), defaultParticipants, () -> true);
        defaultLadderGame = new LadderGame(defaultParticipants, defaultLadder);
    }

    @DisplayName("모든 사용자의 실행결과가 리턴된다")
    @Test
    public void playAllTest() {
        List<Position> result = defaultLadderGame.play("all");

        assertThat(result.size()).isEqualTo(4);
        assertThat(result).containsSequence(Position.of(1),Position.of(0),Position.of(3),Position.of(2));
    }

    @DisplayName("입력한 사용자의 실행 결과가 리턴된다.")
    @Test
    public void playOnlyOneTest() {
        List<Position> result = defaultLadderGame.play("pobi");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result).containsSequence(Position.of(1));
    }

    @DisplayName("all 을 입력하면 게임이 종료여부가 true가 나온다.")
    @Test
    void isFinishGameTest() {
        assertThat(defaultLadderGame.isFinishGame("all")).isTrue();
    }
}
