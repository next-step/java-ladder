package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PointConditionTest {

    private PointCondition pointCondition;

    @BeforeEach
    void init() {
        pointCondition = new PointCondition(false);
    }

    @DisplayName("getCondition 테스트")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getConditionTest(boolean expectedCondition) {
        boolean condition = pointCondition.getCondition(expectedCondition);

        Assertions.assertEquals(condition, expectedCondition);
    }

    @DisplayName("true가 연속으로 입력될경우 false 반환 테스트")
    @Test
    void getConditionContinousTest() {
        boolean firstCondition = pointCondition.getCondition(true);
        boolean secondCondition = pointCondition.getCondition(true);

        Assertions.assertNotEquals(firstCondition, secondCondition);
    }

}