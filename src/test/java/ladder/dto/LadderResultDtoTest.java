package ladder.dto;

import ladder.model.ExecutionResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class LadderResultDtoTest {

    private LadderResultDto ladderResultDto;

    @BeforeEach
    void setUp() {
        Map<String, ExecutionResult> resultMap = Map.of(
                "user1", ExecutionResult.create("1"),
                "user2", ExecutionResult.create("2")
        );

        this.ladderResultDto = LadderResultDto.create(resultMap);
    }

    @Test
    @DisplayName("참여자 이름에 맞는 결과 반환")
    void showLadderResult() {
        //given, when
        ExecutionResult result = ladderResultDto.showLadderResult("user1");

        //then
        Assertions.assertThat(result.toString()).isEqualTo("1");
    }
}