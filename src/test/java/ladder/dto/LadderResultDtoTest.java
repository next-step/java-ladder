package ladder.dto;

import ladder.domain.ExecutionResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultDtoTest {

    @Test
    @DisplayName("참여자 이름에 맞는 결과를 반환한다.")
    void returnResultByParticipantNameTest() {
        // given
        String testUser1 = "testUser1";
        String testUser2 = "testUser2";

        Map<String, ExecutionResult> resultMap = Map.of(
                testUser1, new ExecutionResult("1"),
                testUser2, new ExecutionResult("2")
        );
        LadderResultDto ladderResultDto = new LadderResultDto(resultMap);

        // when
        ExecutionResult result1 = ladderResultDto.showLadderResult(testUser1);
        ExecutionResult result2 = ladderResultDto.showLadderResult(testUser2);

        // then
        assertThat(result1.toString()).isEqualTo("1");
        assertThat(result2.toString()).isEqualTo("2");
    }
}