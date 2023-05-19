package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputResultsTest {

    @Test
    void 입력한_유저이름의_개수와_입력결과의_개수가_다르면_예외가_발생한다() {
        // given
        List<String> results = List.of("꽝", "5000", "3000");
        int countOfNames = 2;

        // when & then
        assertThatThrownBy(() -> new InputResults(results, countOfNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과의 크기가 유저이름의 개수는 같아야 합니다.");
    }
}
