package ladder;

import ladder.domain.Move;
import ladder.domain.Moving;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest {
    Move move1;
    Move move2;
    Move move3;
    Move move4;
    Move move5;

    @BeforeEach
    void setUp() {
        move1 = new Move(false, true);
        move2  = new Move(false, true);
        move3 = new Move(false, false);
        move4 = new Move(true, false);
        move5 = new Move(true, false);
    }

    @Test
    @DisplayName("생성자 Equal 테스트")
    void moveConstructEqualTest() {
        assertThat(move1).isEqualTo(move2);
    }

    @Test
    @DisplayName("움직일 때 인덱스 값 테스트")
    void moveTest() {
        assertThat(Moving.getPosition(move1)).isEqualTo(1);
        assertThat(Moving.getPosition(move2)).isEqualTo(1);
        assertThat(Moving.getPosition(move3)).isEqualTo(0);
        assertThat(Moving.getPosition(move4)).isEqualTo(-1);
        assertThat(Moving.getPosition(move5)).isEqualTo(-1);
    }
}
