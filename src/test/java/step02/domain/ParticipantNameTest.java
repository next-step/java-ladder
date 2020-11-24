package step02.domain;

import exception.OutOfNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipantNameTest {

    private static Stream<String> provideNameResult() {
        return Stream.of(
                "e",
                "e",
                "eyabc"
        );
    }

    @DisplayName("String name 인수 생성자 테스트")
    @ParameterizedTest
    @MethodSource("provideNameResult")
    void test_constructor_of(String name) {
        assertThat(ParticipantName.of(name))
                .isEqualTo(ParticipantName.of(name));
    }

    private static Stream<String> provideInvalidLengthOfNameResult() {
        return Stream.of(
                "",
                "eunyou",
                null
        );
    }

    @DisplayName("이름이 0 ~ 5 자 가 아니면 예외 던짐")
    @ParameterizedTest
    @MethodSource("provideInvalidLengthOfNameResult")
    void test_validate(String name) {
        assertThatExceptionOfType(OutOfNameLengthException.class)
                .isThrownBy(() -> ParticipantName.of(name));
    }

}
