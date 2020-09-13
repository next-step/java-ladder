package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class EntriesTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(new String[]{"pobi", "honux"}, 2),
                Arguments.of(new String[]{"pobi", "honux", "jk"}, 3)
        );
    }

    @ParameterizedTest
    @DisplayName("참가자 수 반환 메소드 검증")
    @MethodSource("provideArguments")
    void getPersonnel(String[] names, int expected) {
        then(Entries.of(Arrays.asList(names)).getPersonnel()).isEqualTo(expected);
    }

    @Test
    @DisplayName("순번으로 Entry 반환 메소드 검증")
    void getEntryByIndex() {
        Entry first = Entry.of("1st");
        Entry second = Entry.of("2nd");
        Entry third = Entry.of("3rd");

        Entries entries = Entries.of(Stream.of("1st", "2nd", "3rd").collect(Collectors.toList()));

        then(entries.getEntryByIndex(0)).isEqualTo(first);
        then(entries.getEntryByIndex(1)).isEqualTo(second);
        then(entries.getEntryByIndex(2)).isEqualTo(third);
    }
}
