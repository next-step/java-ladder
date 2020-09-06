package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    private static Stream<Arguments> provideStringNameForParticipantsTest() {
        return Stream.of(
                Arguments.of("John,Kim,Jason".split(","), 3)
        );
    }

    private static Stream<Arguments> provideStringNameForParticipantsTest_FindName() {
        return Stream.of(
                Arguments.of("John,Kim,Jason".split(","), "Kim", "Kim")
        );
    }

    private static Stream<Arguments> provideStringNameAndCheckConcatString() {
        return Stream.of(
                Arguments.of("John,Jayce,Kim".split(","), "John Jayce Kim")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringNameForParticipantsTest")
    @DisplayName("Participants 생성 테스트 - 생성한 이름 개수만큼, 카운트 집계가 되는가?")
    void create_Participants_For_Ladder_Game(String[] names, int expected) {
        assertThat(Participants.of(names).getNumberOfParticipants()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideStringNameForParticipantsTest_FindName")
    @DisplayName("Participants 생성 테스트 - 생성한 참가자 목록에서 이름으로 검색이 되는가?")
    void create_Participants_For_Ladder_Game_And_Finding_Name(String[] names, String Condition, String expected) {
        assertThat(Participants.of(names).findPersonByName(Condition).printName()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideStringNameAndCheckConcatString")
    @DisplayName("Participants 생성 테스트 - 참가자 목록 나열하는 toString Method가 정상 작동하는가?")
    void create_Participants_For_Ladder_Game_And_Check_ToString(String[] names, String expected) {
        assertThat(Participants.of(names).toString()).isEqualTo(expected);
    }
}
