package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import ladder.TestLinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("음수를 할당하는 경우 Ladder 객체를 생성하는데 실패한다.")
    void create_with_negative_value() {
        assertThatThrownBy(() -> new Ladder(-3, -2)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("0보다 큰 값만 입력 가능합니다.");
    }

    @Test
    @DisplayName("draw 메소드는 사다리를 그려준다.")
    void draw() {
        Ladder ladder = new Ladder(3, 5);
        ladder.draw(new TestLinkStrategy());

        ladder.getLines().forEach(line -> {
            List<Point> linked = line.getPoints().stream()
                .filter(line::isLinkedPoint)
                .collect(Collectors.toList());
            assertAll(
                () -> assertThat(linked.size()).isEqualTo(2),
                () -> assertThat(linked.get(0).getY()).isEqualTo(0),
                () -> assertThat(linked.get(1).getY()).isEqualTo(2)
            );
        });
    }

    @Test
    @DisplayName("play 메소드는 사다리 게임을 진행한 후 결과를 반환한다.")
    void play() {
        Participants participants = new Participants("jordy,penda,kero,cobb");
        Ladder ladder = new Ladder(participants.size(), 5);
        ladder.draw(new TestLinkStrategy());
        ladder.play(participants);

        Participants expected = new Participants("jordy,penda,kero,cobb");
        expected.move(List.of(1, 0, 3, 2));
        assertThat(participants).isEqualTo(expected);
    }
}