package nextstep.ladder.domain.result;

import nextstep.ladder.exception.NullArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 결과 를 표현하는 클래스 테스트")
class ResultTest {

    @DisplayName("문자열을 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(Result.from("1000")).isInstanceOf(Result.class);
    }

    @DisplayName("결과의 값이 null 이거나 비어있거나 5글자를 초과하는 경우 예외를 발생 시킨다")
    @NullAndEmptySource
    @ValueSource(strings = {"100000", "1000000"})
    void initException(String name) {
        assertThatThrownBy(() -> Result.from(name)).isInstanceOf(NullArgumentException.class);
    }

}
