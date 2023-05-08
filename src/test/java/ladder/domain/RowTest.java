package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RowTest {

    @DisplayName("value 가 같으면 동등성 비교가 참을 리턴한다")
    @Test
    public void equals() {
        //given
        //when
        //then
        assertAll("동등성을 검증한다",
                () -> assertThat(Row.of(1)).as("숫자가 같으면 동일하다").isEqualTo(Row.of(1)),
                () -> assertThat(Row.of(2)).as("숫자가 다르면 동일하지 않다").isNotEqualTo(Row.of(4))
        );
    }
}