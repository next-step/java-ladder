package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import ladder.TestLinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("draw 메소드는 사다리를 그려준다.")
    void draw() {
        Ladder ladder = new Ladder(5, 5);
        ladder.draw(new TestLinkStrategy());

        ladder.getLines().forEach(line -> {
            assertThat(line.getAllIsLinked()).isEqualTo(List.of(true, false, true, false, false));
        });
    }

    @Test
    @DisplayName("play 메소드는 사다리 게임을 진행한다.")
    void play() {
        Participants participants = new Participants("jordy,penda,kero,cobb,bero");
        Ladder ladder = new Ladder(participants.size(), 5);
        ladder.draw(new TestLinkStrategy());
        ladder.play(participants);

        Participants expected = new Participants("jordy,penda,kero,cobb,bero");
        expected.move(List.of(new Point(1), new Point(0), new Point(3), new Point(2), new Point(4)));
        assertThat(participants).isEqualTo(expected);
    }
}