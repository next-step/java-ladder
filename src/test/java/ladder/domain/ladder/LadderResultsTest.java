package ladder.domain.ladder;

import ladder.exception.StringListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultsTest {

    @DisplayName("LadderResults 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String[] results = "꽝,5000,꽝,3000".split(",");

        // when
        LadderResults ladderResults = LadderResults.of(results);

        // then
        assertThat(ladderResults).isNotNull();
    }

    @DisplayName("LadderResults 인스턴스 null 입력시 예외처리 여부 테스트")
    @Test
    void 검증_null() {
        // given
        List<String> results = null;

        // when
        assertThatThrownBy(()-> LadderResults.of(results))
                .isInstanceOf(StringListNullPointerException.class)
                .hasMessage("List<String>이 null 입니다.");

    }
}