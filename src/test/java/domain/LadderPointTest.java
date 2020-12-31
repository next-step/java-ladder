package domain;

import ladder.domain.LadderDirection;
import ladder.domain.LadderPoint;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderPointTest {

    private static LadderPoint pointTest;

    @ParameterizedTest
    @DisplayName("입력받은 index가 음수 일대 에러를 던진다.")
    @ValueSource(ints = {-100, -200, -3})
    void checkIndexNegative(int index) {
        assertThatThrownBy(() ->
                pointTest = new LadderPoint(index, new LadderDirection(false, false))
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckPointIndex());
    }
}
