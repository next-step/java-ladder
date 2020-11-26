package step03.domain;

import exception.DuplicatedNameException;
import exception.InvalidCountOfNamesException;
import exception.UsingProhibitedNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipantsTest {

    private static Stream<String> provideNamesResult() {
        return Stream.of(
                "pobi,honux,crong,jk"
        );
    }

    @DisplayName("생성자")
    @ParameterizedTest
    @MethodSource("provideNamesResult")
    void test_constructor_of(String names) {
        assertThat(Participants.of(names))
                .isEqualTo(Participants.of(names));
    }

    private static Stream<Arguments> provideNamesSizeResult() {
        return Stream.of(
                Arguments.of("pobi,honux,crong,jk", 4),
                Arguments.of("pobi,honux", 2)
        );
    }

    @DisplayName("Participants List size")
    @ParameterizedTest
    @MethodSource("provideNamesSizeResult")
    void test_size(String names, Integer size) {
        assertThat(Participants.of(names).size())
                .isEqualTo(size);
    }

    private static Stream<String> provideInvalidCountOfParticipantsResult() {
        return Stream.of("jk", "");
    }

    @DisplayName("Participants 가 1명 이하일 때 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideInvalidCountOfParticipantsResult")
    void test_validateCountOfParticipants_throwException(String name) {
        assertThatExceptionOfType(InvalidCountOfNamesException.class)
                .isThrownBy(() -> Participants.of(name));
    }

    private static Stream<Arguments> provideParticipantsShowResult() {
        return Stream.of(
                Arguments.of("pobi,honux,crong,jk", Arrays.asList("pobi", "honux", "crong", "jk"))
        );
    }

    @DisplayName("출력을 위한 List<Participant> return")
    @ParameterizedTest
    @MethodSource("provideParticipantsShowResult")
    void test_show(String names, List<String> showedParticipant) {
        assertThat(Participants.of(names).getNames())
                .isEqualTo(showedParticipant);
    }


    private static Stream<String> provideDuplicatedParticipantsResult() {
        return Stream.of(
                "pobi,honux,crong,jk,jk"
        );
    }

    @DisplayName("이름이 중복되어 있을 때 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideDuplicatedParticipantsResult")
    void test_show(String names) {
        assertThatExceptionOfType(DuplicatedNameException.class)
                .isThrownBy(() -> Participants.of(names));
    }

    @DisplayName("금지 단어를 포함하고 있으면 예외 던짐")
    @Test
    void test_validateProhibitNames() {
        assertThatExceptionOfType(UsingProhibitedNameException.class)
                .isThrownBy(() -> Participants.of("all,b,c"));
    }

}
