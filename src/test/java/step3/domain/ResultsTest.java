package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ResultsTest {
    @DisplayName("입력한 이름 개수만큼의 결과값을 입력하지 않을 경우 실행에 실패한다.")
    @Test
    public void shouldBeSameSizeWithNames() {
        Assertions.assertThatThrownBy(
                () -> new Results(
                        List.of("꽝,5000,꽝,3000"),
                        NamesTest.testNames.size() - 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}