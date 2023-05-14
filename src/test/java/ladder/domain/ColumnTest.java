package ladder.domain;

import ladder.exception.OutOfColumnRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class ColumnTest {

    @DisplayName("value 가 같으면 동등성 비교가 참을 리턴한다 역명제도 성립한다")
    @Test
    public void equals() {
        //given
        //when
        //then
        assertAll("동등성을 검증한다",
                () -> assertThat(Column.of(1)).as("숫자가 같으면 동일하다").isEqualTo(Column.of(1)),
                () -> assertThat(Column.of(2)).as("숫자가 다르면 동일하지 않다").isNotEqualTo(Column.of(4))
        );
    }
    @DisplayName("범위를 초과한 value 입력시 예외가 발생한다")
    @Test
    public void outOfColumnRangeException() {
        //given
        //when
        //then
        assertThatThrownBy(() -> {
            Column.of(51);
        }).isInstanceOf(OutOfColumnRangeException.class)
                .hasMessageContaining("사용 가능한 Column 의 범위에서 초과하였습니다");
    }
}