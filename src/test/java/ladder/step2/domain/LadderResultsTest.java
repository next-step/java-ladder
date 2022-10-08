package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderResultsTest {
    public static final LadderResults LADDER_RESULTS = new LadderResults("꽝, 5000, 꽝, book", 4);
    
    @Test
    @DisplayName("사다리 실행 결과 생성")
    void create() {
        assertThat(LADDER_RESULTS).isNotNull();
    }
    
    @Test
    @DisplayName("사다리 실행 결과 생성")
    void get_data() {
        assertThat(LADDER_RESULTS.getLadderResults()).isNotNull();
    }
    
    @Test
    @DisplayName("쉼표 외의 구분자는 예외")
    void delimiter_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderResults("꽝, 5000, 꽝. 3000", 4))
                .withMessage("올바른 입력 형식이 아닙니다. 다시 입력해주세요.");
    }
    
    @ParameterizedTest(name = "{displayName}")
    @DisplayName("\"\" 입력시 예외")
    @EmptySource
    void empty_exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderResults(input, 4))
                .withMessage("올바른 입력 형식이 아닙니다. 다시 입력해주세요.");
    }
    
    @Test
    @DisplayName("특수 문자 예외")
    void special_characters_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderResults("꽝, 5?00, 꽝, 3000", 4))
                .withMessage("올바른 입력 형식이 아닙니다. 다시 입력해주세요.");
    }
    
    @Test
    @DisplayName("플레이어 수와 실행 결과 수가 다르면 예외")
    void not_equals_length_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderResults("꽝, 5000, 꽝, 3000", 5))
                .withMessage("플레이어 수 만큼만 입력할 수 있습니다. 다시 입력해주세요.");
    }
    
    @Test
    @DisplayName("매칭되는 결과물 가져오기")
    void get_matching_ladder_result() {
        final LadderResult matchingLadderResult = LADDER_RESULTS.getMatchingLadderResult(PlayerTest.JUN);
        System.out.println(matchingLadderResult.getLadderResult());
        assertThat(matchingLadderResult.getLadderResult()).isEqualTo("꽝");
    }
}