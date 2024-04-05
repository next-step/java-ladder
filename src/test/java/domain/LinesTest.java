package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @DisplayName("갯수와 높이를 기반으로 Lines 객체를 생성한다.")
    @Test
    void test01() {
        Lines lines = Lines.of(4, 5);
        assertThat(lines).isNotNull();
    }

    @DisplayName("입력으로 받은 높이에 다리 (Bridge) 가 있다면 이동한다.")
    @Test
    void test03() {
        Line line1 = Line.createWithBridges(3, () -> true);
        Line line2 = Line.createWithBridges(3, () -> false);
        Lines lines = Lines.from(List.of(line1, line2));
        Position position = lines.move(new Position(0, 0));
        assertThat(position).isEqualTo(new Position(1, 0));
    }
}
