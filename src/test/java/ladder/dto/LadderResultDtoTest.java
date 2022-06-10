package ladder.dto;

import ladder.domain.ExecutionResult;
import ladder.exception.ParticipantNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultDtoTest {

    private String testUser1;
    private String testUser2;
    private Map<String, ExecutionResult> resultMap;

    @BeforeEach
    void setUp() {
        testUser1 = "testUser1";
        testUser2 = "testUser2";

        resultMap = Map.of(
                testUser1, new ExecutionResult("1"),
                testUser2, new ExecutionResult("2")
        );
    }

    @Test
    @DisplayName("참여자 이름에 맞는 결과를 반환한다.")
    void returnResultByParticipantNameTest() {
        // given
        LadderResultDto ladderResultDto = new LadderResultDto(resultMap);

        // when
        ExecutionResult result1 = ladderResultDto.showLadderResult(testUser1);
        ExecutionResult result2 = ladderResultDto.showLadderResult(testUser2);

        // then
        assertThat(result1.toString()).isEqualTo("1");
        assertThat(result2.toString()).isEqualTo("2");
    }

    @Test
    @DisplayName("존재하지 않는 참가자의 결과를 찾는 경우 ParticipantNotFoundException 발생")
    void throwParticipantNotFoundExceptionTest() {
        LadderResultDto ladderResultDto = new LadderResultDto(resultMap);
        assertThatThrownBy(() -> ladderResultDto.showLadderResult("testUser3"))
                .isInstanceOf(ParticipantNotFoundException.class);
    }
}