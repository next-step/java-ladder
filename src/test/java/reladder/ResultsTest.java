package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.Result;
import reladder.domain.Results;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultsTest {

    private Results results;

    @BeforeEach
    void setUp() {
        // give
        results = new Results("꽝,5000,꽝2,3000");
    }

    @Test
    @DisplayName("경품 이름 포함")
    void resultContainsResultObjectTest() {
        // when
        boolean isContains = results.contains(new Result("3000", 2));
        // then
        assertThat(isContains).isTrue();
    }

    @Test
    @DisplayName("경품들 갯수 체크")
    void checkSizeOfResultsTest() {
        // when
        int size = results.size();
        // then
        assertThat(size).isEqualTo(4);
    }

    @Test
    @DisplayName("경품 이름 길이")
    void checkLengthOfResultTest() {
        // when then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Results results = new Results("에어팟2세대");
        });
    }
}
