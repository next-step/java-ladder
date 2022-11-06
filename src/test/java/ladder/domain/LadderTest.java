package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.TestLinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("빈 값을 할당하는 경우 Ladder 객체를 생성하는데 실패한다.")
    void create_with_empty_value() {
        assertThatThrownBy(() -> new Ladder("", 4, "")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("입력 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("참여자가 한 사람 이하인 경우 Ladder 객체를 생성하는데 실패한다.")
    void create_with_one_person() {
        assertThatThrownBy(() -> new Ladder("jordy", 4, "꽝")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("두 항목 이상 필요합니다.");
    }

    @Test
    @DisplayName("음수를 할당하는 경우 Ladder 객체를 생성하는데 실패한다.")
    void create_with_negative_value() {
        assertThatThrownBy(() -> new Ladder("jordy,penda", -2, "꽝,5000")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("0보다 큰 값만 입력 가능합니다.");
    }

    @Test
    @DisplayName("할당된 참여자 수와 결과 수가 다를 경우 Ladder 객체를 생성하는데 실패한다.")
    void create_with_not_equal_value() {
        assertThatThrownBy(() -> new Ladder("jordy,penda", -2, "5000")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("0보다 큰 값만 입력 가능합니다.");
    }

    @Test
    @DisplayName("draw 메소드는 사다리를 그려준다.")
    void draw() {
        Ladder ladder = new Ladder("jordy,penda,kero", 5, "꽝,5000,2000");
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

    @Test
    @DisplayName("play 메소드는 사다리 게임을 진행한 후 결과를 반환한다.")
    void play() {
        Ladder ladder = new Ladder("jordy,penda,kero,cobb", 5, "꽝,5000,2000,꽝");
        ladder.draw(new TestLinkStrategy());
        Map<Name, Prize> result = ladder.play();

        assertAll(
            () -> assertThat(result.get(new Name("jordy")).toString()).isEqualTo("5000"),
            () -> assertThat(result.get(new Name("penda")).toString()).isEqualTo("꽝"),
            () -> assertThat(result.get(new Name("kero")).toString()).isEqualTo("꽝"),
            () -> assertThat(result.get(new Name("cobb")).toString()).isEqualTo("2000")
        );
    }
}