package nextstep.ladder.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalTest {
    @ParameterizedTest
    @DisplayName("값이 10초과, left가 false인 경우면 true를 반환한다.")
    @CsvSource({
            "11,false,true",
            "11,true,false",
            "10,false,false",
            "10,true,false"})
    void test(int number, boolean left, boolean expected) {
        assertThat(new Horizontal(number, left).canHorizontal()).isEqualTo(expected);
    }

}
