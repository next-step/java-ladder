package step04.domain;

import exception.DuplicatedNameException;
import exception.InvalidCountOfNamesException;
import exception.NotFoundNameException;
import exception.UsingProhibitedNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step03.domain.Names;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NamesTest {

    private static Stream<String> provideNamesResult() {
        return Stream.of(
                "pobi,honux,crong,jk",
                "꽝,5000,꽝,3000"
        );
    }

    @DisplayName("생성자")
    @ParameterizedTest
    @MethodSource("provideNamesResult")
    void test_constructor_of(String names) {
        assertThat(Names.of(names)).isEqualTo(Names.of(names));
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
    void test_size(String names, int size) {
        assertThat(Names.of(names).size())
                .isEqualTo(size);
    }

    private static Stream<String> provideInvalidCountOfNameResult() {
        return Stream.of("jk", "");
    }

    @DisplayName("CountOfName 이 1개 이하일 때 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideInvalidCountOfNameResult")
    void test_validate_throwException(String name) {
        assertThatExceptionOfType(InvalidCountOfNamesException.class)
                .isThrownBy(() -> Names.of(name));
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
               assertThat(Names.of(names).getNames()).isEqualTo(showedParticipant);
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
                .isThrownBy(() -> Names.of(names).validateUnique());
    }

    @DisplayName("금지 단어를 포함하고 있으면 예외 던짐")
    @Test
    void test_validateProhibitNames() {
        assertThatExceptionOfType(UsingProhibitedNameException.class)
                .isThrownBy(() -> Names.of("all,b,c").validateProhibitNames("all"));
    }

    private static Stream<Arguments> provideNameIndexResult()
    {
        return Stream.of(
                Arguments.of("pobi", 0),
                Arguments.of("honux", 1),
                Arguments.of("crong", 2),
                Arguments.of("jk", 3)
        );
    }

    @DisplayName("이름으로 인덱스 찾기")
    @ParameterizedTest
    @MethodSource("provideNameIndexResult")
    void test_indexOf(String name, int index) {
        assertThat(
                Names.of("pobi,honux,crong,jk").indexOf(name)
        ).isEqualTo(index);
    }

    @DisplayName("이름을 찾을 수 없으면 예외 던짐")
    @Test
    void test_indexOf_invalid() {
        assertThatExceptionOfType(NotFoundNameException.class)
            .isThrownBy(() -> Names.of("pobi,honux,crong,jk").indexOf("name"));
    }


}
