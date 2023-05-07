package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderInputsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", "pobi, honux, crong, jk"})
    @DisplayName("참가자 객체 생성 테스트")
    void createParticipantsTest(String inputNames) {
        String[] splitNames = inputNames.split(",");
        List<String> names = List.of(splitNames);
        LadderInputs participants = LadderInputs.from(names);

        assertThat(participants.countOfInputs())
                .isEqualTo(4);
    }

    @Test
    @DisplayName("실행 결과 생성 테스트")
    void createResultsTest() {
        String[] splitNames = "pobi,honux,crong,jk".split(",");
        List<String> names = List.of(splitNames);
        LadderInputs participants = LadderInputs.from(names);

        String inputResults = "꽝,5000,꽝,3000";
        String[] splitResults = inputResults.split(",");
        List<String> results = List.of(splitResults);
        LadderInputs ladderResults = LadderInputs.from(results, participants);

        assertThat(ladderResults.countOfInputs())
                .isEqualTo(4);
    }

    @Test
    @DisplayName("실행 결과 개수와 참여할 사람 이름 수가 안맞을 경우 에러 반환 테스트")
    void notEqualsResultsCountToParticipants() {
        String[] splitNames = "pobi,honux,crong".split(",");
        List<String> names = List.of(splitNames);
        LadderInputs participants = LadderInputs.from(names);

        String inputResults = "꽝,5000,꽝,3000";
        String[] splitResults = inputResults.split(",");
        List<String> results = List.of(splitResults);

        assertThatThrownBy(() -> LadderInputs.from(results, participants))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여할 사람 수와 결과 개수가 맞지 않습니다.");
    }

}
