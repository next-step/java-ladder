package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("양수")
class PositiveTest {

    @Test
    @DisplayName("양수로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Positive.from(Integer.MAX_VALUE));
    }

    @Test
    @DisplayName("0과 음수로 생성 불가능")
    void instance_zeroOrNegative_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Positive.from(0));
        assertThatIllegalArgumentException().isThrownBy(() -> Positive.from(-1));
    }

    @Test
    @DisplayName("더하기")
    void add() {
        assertThat(Positive.ONE.add(Positive.ONE)).isEqualTo(Positive.from(2));
    }

    @Test
    @DisplayName("더하는 값은 필수")
    void add_nullValue_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Positive.ONE.add(null));
    }


    @Test
    @DisplayName("빼기")
    void minus() {
        assertThat(Positive.from(2).minus(Positive.ONE)).isEqualTo(Positive.ONE);
    }

    @Test
    @DisplayName("빼는 값은 필수")
    void minus_nullValue_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Positive.ONE.minus(null));
    }

    @ParameterizedTest(name = "[{index}] 2가 {0} 보다 미만인 것은 {1}")
    @DisplayName("2보다 미만 여부 판단")
    @CsvSource({"2,false", "3,true"})
    void lessThan(int value, boolean expected) {
        assertThat(Positive.from(2).lessThan(Positive.from(value))).isEqualTo(expected);
    }

    @Test
    @DisplayName("비교할 값은 필수")
    void lessThan_nullValue_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Positive.ONE.lessThan(null));
    }

    @ParameterizedTest(name = "[{index}] 2 가 {0} 보다 이하인 것은 {1}")
    @DisplayName("2보다 이하 여부 판단")
    @CsvSource({"1,false", "2,true", "3,true"})
    void lessThanOrEqual(int value, boolean expected) {
        assertThat(Positive.from(2).lessThanOrEqual(Positive.from(value))).isEqualTo(expected);
    }
}
