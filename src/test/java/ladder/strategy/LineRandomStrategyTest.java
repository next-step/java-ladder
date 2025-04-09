package ladder.strategy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LineRandomStrategyTest {
    @Test
    @DisplayName("리스트 크기가 countOfPersons - 1인지 확인")
    void testHasHorizontalLineSize() {
        int countOfPersons = 10;
        int expectedSize = countOfPersons - 1;
        List<Boolean> booleanList = new LineRandomStrategy().hasHorizontalLine(countOfPersons);

        assertThat(expectedSize).isEqualTo(booleanList.size());
    }

    @RepeatedTest(100)
    @DisplayName("리스트의 요소 중 true 가 연속으로 나타나지 않는지 확인")
    void testGenerateRandomBooleanList() {
        int countOfPersons = 10;
        List<Boolean> booleanList = new LineRandomStrategy().hasHorizontalLine(countOfPersons);

        for (int i = 0; i < booleanList.size() - 1; i++) {
            if (booleanList.get(i)) {
                assertThat(booleanList.get(i + 1)).isFalse();
            }
        }
    }

    @Test
    @DisplayName("리스트의 요소가 null 이 아닌지 확인")
    void testHasHorizontalLineEdgeCase() {
        LineRandomStrategy strategy = new LineRandomStrategy();
        int minCountOfPersons = 2;
        List<Boolean> booleanList = strategy.hasHorizontalLine(minCountOfPersons);

        assertThat(1).isEqualTo(booleanList.size());
        assertNotNull(booleanList.get(0));
    }
}
