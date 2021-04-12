package ladder;

import ladder.domain.LadderResult;
import ladder.domain.ResultElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderResultTest {
    private static final List<ResultElement> givenResultElements = Arrays.asList(
            new ResultElement("a", "1"),
            new ResultElement("b", "2"),
            new ResultElement("c", "3"),
            new ResultElement("d", "4")
    );

    @Test
    @DisplayName("LadderResult 생성 테스트")
    void When_New_Then_Created() {
        assertDoesNotThrow((Executable) LadderResult::new);
    }

    @Test
    @DisplayName("특정 플레이어의 결과값 가지고 오기")
    void Given_PlayerName_When_Result_Then_RightValue() {
        LadderResult ladderResult = new LadderResult(givenResultElements);

        LadderResult results = ladderResult.result("a");

        assertThat(results).isEqualTo(new LadderResult(givenResultElements.get(0)));
    }

    @Test
    @DisplayName("모든 플레이어의 결과값 가지고 오기")
    void Given_AllPlayer_When_Result_Then_RightValue() {
        LadderResult ladderResult = new LadderResult(givenResultElements);

        LadderResult allResults = ladderResult.result("all");

        assertThat(allResults).isEqualTo(ladderResult);
    }
}
