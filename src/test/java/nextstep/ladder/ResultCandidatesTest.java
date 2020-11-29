package nextstep.ladder;

import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.ResultCandidates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ResultCandidatesTest {
    @Test
    @DisplayName("실행결과의 size는 입력된 input 실행결과와 size()가 같아야 한다.")
    void resultsSizeTest() {
        //given
        Participants participants = Participants.of("참가자1", "참가자2", "참가자3", "참가자4");
        List<String> executionResultInput = Arrays.asList("꽝", "5000", "꽝", "3000");

        //when
        ResultCandidates resultCandidates = ResultCandidates.of(participants.getNumberOfParticipants(), executionResultInput);

        //then
        assertThat(resultCandidates.size()).isEqualTo(executionResultInput.size());
    }

    @Test
    @DisplayName("참가자 숫자와 실행결과의 사이즈가 다르면 throw Exception")
    void invalidSizeTest() {
        Participants participants = Participants.of("참가자1", "참가자2", "참가자3");
        List<String> executionResultInput = Arrays.asList("꽝", "5000", "꽝", "3000");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ResultCandidates.of(participants.getNumberOfParticipants(), executionResultInput))
                .withMessage(ResultCandidates.INVALID_SIZE_ERR_MSG);
    }
}
