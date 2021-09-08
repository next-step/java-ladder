package nextstep.ladder.participant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @ParameterizedTest
    @NullAndEmptySource
    void emptyName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Participant(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "aaaaaaaa"})
    void overLengthName(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Participant(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "aa","aaa","aaaa","aaaaa"})
    void test(String name) {
        Participant participant = assertDoesNotThrow(() -> new Participant(name));
        assertEquals(name, participant.getName());
    }
}