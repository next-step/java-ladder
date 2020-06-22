package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("상품 생성 테스트")
class PriceTest {

    @DisplayName("올바른 상품 입력값 ")
    @ParameterizedTest
    @CsvSource(value = {"꽝", "5000", "3000"})
    public void create_validPrice_shouldSuccess(String param) {
        Price price = new Price(param);
        assertThat(price.getMoney()).isEqualTo(param);
    }

    @DisplayName("꽝이나 숫자 형식이 아니라면 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"꽝!", "01sa", "jk"})
    public void create_invalidPrice_shouldFail(String param) {
        assertThatThrownBy(() -> {
            Price price = new Price(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
