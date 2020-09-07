package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.BDDAssertions.then;

class PointTest {

    @ParameterizedTest
    @DisplayName("페달 여부 확인")
    @CsvSource(value = {"true,true", "false,false"})
    void isPedalExist(boolean hasPedal, boolean expected) {
        then(new Point(hasPedal).isPedalExist()).isEqualTo(expected);
    }
}
