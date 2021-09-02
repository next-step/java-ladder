package nextstep.ladder.domain.participant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

    private Participants participants;

    @BeforeEach
    void setUp() {
        List<Participant> participantsList = Arrays.asList(
                new Participant("pobi"),
                new Participant("honux"),
                new Participant("crong"),
                new Participant("jk")
        );

        participants = new Participants(participantsList);
    }

    @Test
    @DisplayName("사이즈 테스트")
    void size() {
        assertEquals(4, participants.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    void findByParticipantName(String input) {
        Name name = new Name(input);

        Participants actual = assertDoesNotThrow(() -> participants.findByName(name));
        assertEquals(1, actual.size());
        assertEquals(input, actual.get(0).getName());
    }

    @ParameterizedTest
    @DisplayName("이름이 all인 경우 모든 참여자를 가진 Participants를 리턴한다")
    @MethodSource("nameParams")
    void findByParticipantNameAll(List<Name> input) {
        Name name = new Name("all");
        Participants actual = assertDoesNotThrow(() -> participants.findByName(name));

        assertEquals(4, actual.size());
        assertEquals(input.get(0).getValue(), actual.get(0).getName());
        assertEquals(input.get(1).getValue(), actual.get(1).getName());
        assertEquals(input.get(2).getValue(), actual.get(2).getName());
        assertEquals(input.get(3).getValue(), actual.get(3).getName());
    }

    private static Stream<Arguments> nameParams() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new Name("pobi"),
                                new Name("honux"),
                                new Name("crong"),
                                new Name("jk")
                        )
                )
        );
    }

    @ParameterizedTest
    @DisplayName("존재하지 않는 이름인 경우 예외가 발생한다")
    @MethodSource("notExistsNameParams")
    void findByParticipantNameThrowsException(Name name) {
        assertThrows(IllegalArgumentException.class, () -> participants.findByName(name));
    }

    private static Stream<Arguments> notExistsNameParams() {
        return Stream.of(
                Arguments.of(new Name("test1")),
                Arguments.of(new Name("test2"))
        );
    }
}