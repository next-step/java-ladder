package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.exception.IllegalExecutionResultException;
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
        Results results = new Results(names, 3);

        // then
        assertThat(results.getValues()).hasSize(3);
    }

    @ParameterizedTest(name = "실행결과 입력이 {0}인 경우 예외처리를 한다")
    @NullAndEmptySource
    void exceptionExecutionResultNullAndEmpty(String[] values) {
        // when & then
        assertThatThrownBy(() -> new Results(values, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행결과의 갯수가 참가자의 수와 다른 경우 예외처리를 한다")
    void exceptionExecutionResultCountNotMatchedParticipantCount() {
        // given
        String[] names = new String[]{"꽝", "5000", "10000"};

        // when & then
        assertThatThrownBy(() -> new Results(names, 5))
                .isInstanceOf(IllegalExecutionResultException.class);
    }
}