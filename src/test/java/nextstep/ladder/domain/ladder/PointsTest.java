package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {

    @Test
    @DisplayName("연결여부 리스트를 갖는다.(테스트를 위해 BooleanGenerator: return false only)")
    void test01() {
        Points points = Points.initialize(5, () -> false);

        System.out.println(points.getConnectionStatuses());

        assertThat(points.getConnectionStatuses()).doesNotContain(new ConnectionStatus(true));
    }

    @Test
    @DisplayName("초기값 수 만큼 연결여부 리스트를 생성한다.")
    void test02() {
        int pointSize = 5;
        Points points = Points.initialize(pointSize, new RandomBooleanGenerator());

        assertThat(points.getConnectionStatuses()).hasSize(pointSize);
    }

    @Test
    @DisplayName("연속해서 연결된 값(true)를 가질 수 없다.(테스트를 위해 BooleanGenerator: return true only)")
    void test03() {
        Points points = Points.initialize(10, () -> true);

        System.out.println(points.getConnectionStatuses());

        Boolean actual = points.getConnectionStatuses()
                .stream()
                .map(ConnectionStatus::isConnected)
                .reduce((prev, next) -> prev && next)
                .get();

        assertThat(actual).isFalse();
    }


    @Test
    @DisplayName("points 는 가지고 있는 연결여부 리스트의 크기를 반환한다.")
    void test04() {
        int pointSize = 5;
        Points points = Points.initialize(pointSize, new RandomBooleanGenerator());

        assertThat(points.size()).isEqualTo(pointSize);
    }
    
}
