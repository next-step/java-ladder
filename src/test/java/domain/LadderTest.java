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
        Line line1 = Line.createWithBridges(5, () -> false);
        Line line2 = Line.createWithBridges(5, () -> true);
        Line line3 = Line.createWithBridges(5, () -> false);
        Ladder ladder = new Ladder(new Lines(List.of(line1, line2, line3)));

        int position = ladder.getEndPoint(0);

        assertThat(position).isEqualTo(3);
    }
}
