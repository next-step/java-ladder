package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
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
}
