package nextstep.ladder.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private static final String PARTICIPANT_NAMES = "pobi,honux,crong,jk";
    private static final String HEIGHT_OF_LADDER = "1";
    private static final String EXECUTION_RESULTS = "꽝,5000,꽝,3000";

    @Test
    void readParticipantNamesTest() {
        // given
        inputParticipantNames();
        // when
        List<String> userNames = InputView.readUserNames();
        // then
        assertThat(userNames).isEqualTo(Arrays.stream(PARTICIPANT_NAMES.split(",")).collect(Collectors.toList()));
    }

    @Test
    void readHeightOfLadderTest() {
        // given
        inputHeightOfLadder();
        // when
        int heightOfLadder = InputView.readHeightOfLadder();
        // then
        assertThat(heightOfLadder).isEqualTo(Integer.parseInt(HEIGHT_OF_LADDER));
    }

    @Test
    void readLadderResultsTest() {
        // given
        inputSystemValue(EXECUTION_RESULTS);
        // when & then
        assertThat(InputView.readLadderResults()).containsExactly(EXECUTION_RESULTS.split(","));
    }

    @ParameterizedTest
    @ValueSource(strings = {"all", "exit", "crong"})
    void readCommandForResultOfTargetUserTest(String command) {
        // given
        inputSystemValue(command);
        // when & then
        assertThat(InputView.readCommandForResultOfTargetUser()).isEqualTo(command);
    }

    private void inputParticipantNames() {
        inputSystemValue(PARTICIPANT_NAMES);
    }

    private void inputHeightOfLadder() {
        inputSystemValue(HEIGHT_OF_LADDER);
    }

    private void inputSystemValue(String input) {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
