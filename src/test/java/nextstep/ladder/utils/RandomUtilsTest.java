package nextstep.ladder.utils;

import nextstep.ladder.domain.impl.line.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class RandomUtilsTest {

    @DisplayName("랜덤 boolean 배열 생성 후 Line 생성하여도 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 20})
    void validBooleanList(int countOfPoint) {
        List<Boolean> booleanList = RandomUtils.getBooleanList(countOfPoint);
        LadderLine.from(booleanList);
    }
}
