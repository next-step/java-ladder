package step04.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step04.domain.Name;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    private static Stream<Arguments> provideListOfNameResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(Name.of("12"), Name.of("12"), Name.of("13")), false),
                Arguments.of(Arrays.asList(Name.of("12"), Name.of("14"), Name.of("13")), true)
        );
    }


    @ParameterizedTest
    @MethodSource("provideListOfNameResult")
    void test_isUnique(List<Name> list, boolean expect) {
        assertThat(Validator.isUnique(list)).isEqualTo(expect);
    }

}