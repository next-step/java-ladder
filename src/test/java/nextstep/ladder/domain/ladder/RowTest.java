package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RowTest {

    @Test
    @DisplayName("연결이 되어있지 않다면 움직이지 않는다.(테스트를 위해 BooleanGenerator: return false only)")
    void test01() {
        Row row = Row.initialize(5, () -> false);
        assertThat(row.connectionType(new Position(0)))
                .isSameAs(ConnectionType.NONE);
    }

    @Test
    @DisplayName("연결이 되어있다면 움직인다 / 연속해서 연결된 값(true)를 가질 수 없다.(테스트를 위해 BooleanGenerator: return true only)")
    void test02() {
        Row row = Row.initialize(5, () -> true);

        assertThat(row.connectionType(new Position(0)))
                .isSameAs(ConnectionType.RIGHT);
        assertThat(row.connectionType(new Position(1)))
                .isSameAs(ConnectionType.LEFT);
        assertThat(row.connectionType(new Position(2)))
                .isSameAs(ConnectionType.RIGHT);
        assertThat(row.connectionType(new Position(3)))
                .isSameAs(ConnectionType.LEFT);
    }

}
