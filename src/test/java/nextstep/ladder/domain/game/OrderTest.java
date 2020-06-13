package nextstep.ladder.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OrderTest {

    @Test
    @DisplayName("순서 생성 테스트")
    void create(){
        Order order = Order.from(5);
        assertThat(order).isEqualTo(Order.from(5));
    }
    @Test
    @DisplayName("순서 예외 테스트")
    void exception(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Order.from(-1));
    }

    @ValueSource(ints = {6})
    @ParameterizedTest
    @DisplayName("order isLessThanMaxPosition 테스트")
    void isLessThanMaxPosition(int maxPosition){
        assertThat(Order.from(5).isLessThanMaxPosition(maxPosition)).isTrue();
    }
}
