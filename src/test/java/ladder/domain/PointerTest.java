package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointerTest {

    @Test
    @DisplayName("Pointer 객체에 True 값만 넘길경우 IllegalStateException 발생 ")
    void pointer_sameTrueType_throwIllegalStateException() {
        assertThatThrownBy(() -> {
            Pointer pointer = Pointer.of(true,true);
        }).isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("두 상태값이 True 일 수 없습니다");
    }

    @Test
    @DisplayName("Pointer next 값 예상")
    void pointer_nextExpected_isEqualTo() {
        Pointer pointer = Pointer.of(false,false);
        Pointer actual = Pointer.next(pointer,true);

        assertThat(actual).isEqualTo(Pointer.of(false,true));
    }
}
