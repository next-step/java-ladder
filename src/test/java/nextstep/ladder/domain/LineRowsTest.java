package nextstep.ladder.domain;

import nextstep.ladder.domain.generator.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineRowsTest {

    @Test
    @DisplayName("연결여부 리스트를 갖는다.(테스트를 위해 BooleanGenerator: return false only)")
    void test01() {
        LineRows lineRows = LineRows.initialize(5, () -> false);

        System.out.println(lineRows.getConnectionStatuses());

        assertThat(lineRows.getConnectionStatuses()).doesNotContain(new ConnectionStatus(true));
    }

    @Test
    @DisplayName("사용자 수 보다 하나작은 연결여부 리스트를 생성한다.")
    void test02() {
        int userCount = 5;
        LineRows lineRows = LineRows.initialize(5, new RandomBooleanGenerator());

        assertThat(lineRows.getConnectionStatuses()).hasSize(userCount - 1);
    }

    @Test
    @DisplayName("연속해서 연결된 값(true)를 가질 수 없다.(테스트를 위해 BooleanGenerator: return true only)")
    void test03() {
        LineRows lineRows = LineRows.initialize(10, () -> true);

        System.out.println(lineRows.getConnectionStatuses());

        Boolean actual = lineRows.getConnectionStatuses()
                .stream()
                .map(ConnectionStatus::isConnected)
                .reduce((prev, next) -> prev && next)
                .get();

        assertThat(actual).isFalse();
    }

}
