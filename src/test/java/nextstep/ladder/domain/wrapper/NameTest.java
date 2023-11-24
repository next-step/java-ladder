package nextstep.ladder.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static nextstep.ladder.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @DisplayName("이름을 생성한다.")
    @Test
    void createName() {
        assertThat(new Name("홍길동").toString()).isEqualTo("홍길동");
    }

    @DisplayName("이름의 글자 수가 5글자를 초과하면 예외를 던진다.")
    @Test
    void createNameWhenNameSizeOverFive() {
        assertThatThrownBy(() -> new Name("여섯글자이름")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(OUT_OF_RANGE.message());
    }

    @DisplayName("이름의 글자 수가 빈 문자열이면 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createNameWhenNameEmpty(String name) {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NOT_NONE.message());
    }
}
