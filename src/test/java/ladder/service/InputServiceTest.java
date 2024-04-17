package ladder.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputServiceTest {
    @Test
    @DisplayName("참가자 이름 잘라내기 테스트")
    public void parseParticipantsStringTest() {
        String input = "ik, oop, ddp, cho";

        List<String> parsedParticipants = InputService.parseParticipants(input);

        assertThat(parsedParticipants.size()).isEqualTo(4);
        assertThat(parsedParticipants.get(0)).isEqualTo("ik");
        assertThat(parsedParticipants.get(1)).isEqualTo("oop");
    }

    @Test
    @DisplayName("다섯글자 초과 이름 예외 처리 테스트")
    public void parseOverFiveLetterParticipantsError() {
        String input = "ik, oop, ddp, chokkk";

        assertThatThrownBy(() -> InputService.parseParticipants(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 다섯글자를 넘길 수 없습니다.");
    }

    @Test
    @DisplayName("1보다 작은 사다리 길이 입력 검증 테스트")
    public void validateLadderHeightLessThanZeroTest() {
        assertThatThrownBy(() -> InputService.validateLadderHeight(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 1보다 작을 수 없습니다.");
    }

}