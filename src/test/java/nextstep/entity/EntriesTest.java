package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class EntriesTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(new Entry[]{new Entry("pobi"), new Entry("honux")}, 2),
                Arguments.of(new Entry[]{new Entry("pobi"), new Entry("honux"), new Entry("jk")}, 3)
        );
    }

    @ParameterizedTest
    @DisplayName("생성자 유효성 처리 확인")
    @MethodSource("provideArguments")
    void getPersonnel(Entry[] entries, int expected) {
        then(new Entries(List.of(entries)).getPersonnel()).isEqualTo(expected);
    }
}
