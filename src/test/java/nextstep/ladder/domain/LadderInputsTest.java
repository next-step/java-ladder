package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderInputsTest {

    private LadderInputs testLadderInputSetup(String stringInputs) {
        List<String> names = List.of(stringInputs.split(","));
        return LadderInputs.from(names);
    }

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
        LadderInputs participants = testLadderInputSetup("pobi,honux,crong,jk");

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
        LadderInputs participants = testLadderInputSetup("pobi,honux,crong");

        String inputResults = "꽝,5000,꽝,3000";
        String[] splitResults = inputResults.split(",");
        List<String> results = List.of(splitResults);

        assertThatThrownBy(() -> LadderInputs.from(results, participants))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여할 사람 수와 결과 개수가 맞지 않습니다.");
    }

    @Test
    @DisplayName("이름 포함 여부 테스트")
    void hasNameTest() {
        LadderInputs participants = testLadderInputSetup("pobi,honux,crong");

        assertThat(participants.hasName(new LadderInput("pobi")))
                .isTrue();
    }

    @Test
    @DisplayName("이름 미포함 여부 테스트")
    void noNameTest() {
        LadderInputs participants = testLadderInputSetup("pobi,honux,crong");

        assertThat(participants.hasName(new LadderInput("jk")))
                .isFalse();
    }

    @Test
    @DisplayName("이름 가져오기 테스트")
    void nameIndexTest() {
        LadderInputs participants = testLadderInputSetup("pobi,honux,crong");

        assertThat(participants.nameIndex(new LadderInput("pobi")))
                .isEqualTo(0);

        assertThat(participants.nameIndex(new LadderInput("honux")))
                .isEqualTo(1);

        assertThat(participants.nameIndex(new LadderInput("crong")))
                .isEqualTo(2);

    }

}
