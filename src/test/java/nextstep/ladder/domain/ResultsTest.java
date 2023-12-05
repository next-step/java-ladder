package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ResultsTest {
    @DisplayName("참가인원과 실행결과의 수가 다르다면 예외 발생")
    @Test
    void 실행결과_검증() {
        Participants participants = new Participants(new ArrayList<>(Arrays.asList("jae", "hyeon")));
        List<String> results = new ArrayList<>(Arrays.asList("next", "꽝", "수료"));
        Assertions.assertThatThrownBy(() -> Results.of(participants, results))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여인원과 결과값의 수가 다릅니다.");
    }
}