package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {
    @Test
    @DisplayName("[Results.of] 쉼표로 구분된 실행 결과 주면 -> 분리해서 반환")
    public void ofTest() {
        assertThat(Results.of("hello,world,my,result"))
                .hasSameElementsAs(
                        List.of(new ResultItem("hello"),
                                new ResultItem("world"),
                                new ResultItem("my"),
                                new ResultItem("result"))
                );
    }
}