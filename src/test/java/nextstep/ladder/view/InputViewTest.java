package nextstep.ladder.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private static final String PARTICIPANT_NAMES = "pobi,honux,crong,jk";

    @Test
    void readParticipantNamesTest() {
        // given
        inputParticipantNames();
        // when
        String participantNames = InputView.readParticipantNames();
        // then
        assertThat(participantNames).isEqualTo(PARTICIPANT_NAMES);
    }

    private void inputParticipantNames() {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
        System.setIn(new ByteArrayInputStream(PARTICIPANT_NAMES.getBytes()));
    }
}
