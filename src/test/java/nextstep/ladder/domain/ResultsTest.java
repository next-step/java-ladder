package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ResultsTest {
    @Test
    @DisplayName("실행결과 생성을 확인합니다")
    void checkedExecutionResultGenerate() {
        // given
        String[] names = new String[]{"꽝", "5000", "10000"};

        // when
        Results results = new Results(names);

        // then
        assertThat(results.getValues()).hasSize(3);
    }

    @ParameterizedTest(name = "실행결과 입력이 {0}인 경우 예외처리를 한다.")
    @NullAndEmptySource
    void exceptionExecutionResultNullAndEmpty(String[] values) {
        // when & then
        assertThatThrownBy(() -> new Results(values))
                .isInstanceOf(IllegalArgumentException.class);
    }
}