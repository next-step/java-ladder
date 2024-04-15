package domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("전체 플레이어 수와 높이를 입력받아 Ladder 객체를 생성한다.")
    @Test
    void test() {
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder).isNotNull();
    }

    @DisplayName("시작 위치를 입력받아 끝 위치를 출력한다.")
    @Test
    void test02() {
        Line line1 = Line.createWithBridges(5, () -> true);
        Line line2 = Line.createWithBridges(5, () -> false);
        Line line3 = Line.createWithBridges(5, () -> false);
        Ladder ladder = new Ladder(Lines.from(List.of(line1, line2, line3)));

        Position position = ladder.getEndPositionByStartPosition(new Position(0, 0));

        assertThat(position).isEqualTo(new Position(1, 5));
    }

    @DisplayName("시작 column 을 입력받아 최종 column 을 출력한다.")
    @Test
    void test03() {
        Bridge first = Bridge.first(true);
        Bridge second = first.next(false);
        Bridge third = second.next(true);
        Bridges firstHeightBridges = new Bridges(List.of(first, second, third));

        Bridge first1 = Bridge.first(false);
        Bridge second1 = first.next(true);
        Bridge third1 = second.next(false);
        Bridges secondHeightBridges = new Bridges(List.of(first, second, third));

        Bridge first2 = Bridge.first(true);
        Bridge second2 = first.next(false);
        Bridge third2 = second.next(true);
        Bridges thirdHeightBridges = new Bridges(List.of(first, second, third));
        Ladder ladder = new Ladder(List.of(firstHeightBridges, secondHeightBridges, thirdHeightBridges));
        assertThat(ladder.getEndColumn(0)).isEqualTo(2);
    }
}
