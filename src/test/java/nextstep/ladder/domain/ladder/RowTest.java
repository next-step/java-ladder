package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RowTest {

    @Test
    @DisplayName("연결여부 리스트를 갖는다.(테스트를 위해 BooleanGenerator: return false only)")
    void test01() {
        Row row = Row.initialize(5, () -> false);

        System.out.println(row.getConnectionTypes());

        assertThat(row.getConnectionTypes()).doesNotContain(ConnectionType.RIGHT);
    }

    @Test
    @DisplayName("초기값 수 만큼 연결여부 리스트를 생성한다.")
    void test02() {
        int pointSize = 5;
        Row row = Row.initialize(pointSize, new RandomBooleanGenerator());

        assertThat(row.getConnectionTypes()).hasSize(pointSize);
    }

    @Test
    @DisplayName("연속해서 연결된 값(true)를 가질 수 없다.(테스트를 위해 BooleanGenerator: return true only)")
    void test03() {
        Row row = Row.initialize(10, () -> true);

        System.out.println(row.getConnectionTypes());

        Boolean actual = row.getConnectionTypes()
                .stream()
                .map(ConnectionType::isRight)
                .reduce((prev, next) -> prev && next)
                .get();

        assertThat(actual).isFalse();
    }

}
