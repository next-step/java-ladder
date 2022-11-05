package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.TestLinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("빈 값을 할당하는 경우 Ladder 객체를 생성하는데 실패한다.")
    void create_with_empty_value() {
        assertThatThrownBy(() -> new Ladder("", 4)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("입력 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("참여자가 한 사람 이하인 경우 Ladder 객체를 생성하는데 실패한다.")
    void create_with_one_person() {
        assertThatThrownBy(() -> new Ladder("jordy", 4)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("두 사람 이상 참여해야 합니다.");
    }

    @Test
    @DisplayName("음수를 할당하는 경우 Ladder 객체를 생성하는데 실패한다.")
    void create_with_negative_value() {
        assertThatThrownBy(() -> new Ladder("jordy,penda", -2)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("0보다 큰 값만 입력 가능합니다.");
    }

    @Test
    @DisplayName("draw 메소드는 사다리를 그려준다.")
    void draw() {
        Ladder ladder = new Ladder("jordy,penda,kero", 5);
        ladder.draw(new TestLinkStrategy());

        ladder.getLines().forEach(line -> {
            List<Point> linked = line.getPoints().stream()
                .filter(Point::isLinked)
                .collect(Collectors.toList());
            assertAll(
                () -> assertThat(linked.size()).isEqualTo(2),
                () -> assertThat(linked.get(0).getY()).isEqualTo(0),
                () -> assertThat(linked.get(1).getY()).isEqualTo(2)
            );
        });
    }
}