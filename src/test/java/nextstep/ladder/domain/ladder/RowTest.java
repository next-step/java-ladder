package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RowTest {

    @Test
    @DisplayName("연결이 되어있지 않다면 움직이지 않는다.(테스트를 위해 BooleanGenerator: return false only)")
    void test01() {
        Row row = Row.initialize(5, () -> false);
        assertThat(row.movePoint(0)).isZero();
    }

    @Test
    @DisplayName("연결이 되어있다면 움직인다 / 연속해서 연결된 값(true)를 가질 수 없다.(테스트를 위해 BooleanGenerator: return true only)")
    void test02() {
        Row row = Row.initialize(5, () -> true);

        assertThat(row.movePoint(0)).isOne();
        assertThat(row.movePoint(1)).isEqualTo(-1);
        assertThat(row.movePoint(2)).isOne();
        assertThat(row.movePoint(3)).isEqualTo(-1);
    }

}
