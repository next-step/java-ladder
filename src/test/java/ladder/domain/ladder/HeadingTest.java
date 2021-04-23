package ladder.domain.ladder;

import ladder.exception.IllegalBooleanArgumentsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class HeadingTest {

    @DisplayName("Heading enum 생성 여부 테스트")
    @Test
    void 생성() {
        assertAll(
                () -> assertThat(Heading.RIGHT).isNotNull(),
                () -> assertThat(Heading.LEFT).isNotNull(),
                () -> assertThat(Heading.PASS).isNotNull()
        );
    }

    @DisplayName("Heading enum 적절한 값 입력시 알맞은 열거형 생성 여부 테스트")
    @Test
    void 생성_valueOf() {
        assertAll(
                () -> assertThat(Heading.valueOf(false, true)).isEqualTo(Heading.RIGHT),
                () -> assertThat(Heading.valueOf(true, false)).isEqualTo(Heading.LEFT),
                () -> assertThat(Heading.valueOf(false, false)).isEqualTo(Heading.PASS)
        );
    }

    @DisplayName("Heading enum 부적절한 값 입력시 예외처리 여부 테스트")
    @Test
    void 생성_부적절한_값() {
        assertThatThrownBy(()-> Heading.valueOf(true, true))
                .isInstanceOf(IllegalBooleanArgumentsException.class)
                .hasMessage("(true, true)는 알맞은 boolean 타입의 매개변수가 아닙니다.");
    }


}