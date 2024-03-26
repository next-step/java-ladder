package strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomPointsMakeStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("makePoints()의 매개변수 - 1의 사이즈를 가지는 List<Boolean> 반환")
    void makePoints(int playerCount) {
        PointsMakeStrategy pointsMakeStrategy = new RandomPointsMakeStrategy();
        List<Boolean> points = pointsMakeStrategy.makePoints(playerCount);
        assertThat(points).hasSize(playerCount - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("makePoints()의 반환 리스트는 true가 연속적으로 나올 수 없음")
    void makePoints_true_cant_be_continuous(int playerCount) {
        PointsMakeStrategy pointsMakeStrategy = new RandomPointsMakeStrategy();
        List<Boolean> points = pointsMakeStrategy.makePoints(playerCount);
        for (int i = 1; i < points.size(); i++) {
            Boolean point = points.get(i);
            if (!point) {
                continue;
            }
            assertThat(point).isNotEqualTo(points.get(i - 1));
        }
    }
}
