package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import step02.domain.Participant;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    private static Stream<String> provideNameResult() {
        return Stream.of(
                "e",
                "e",
                "eyabc"
        );
    }

    @DisplayName("생성자")
    @ParameterizedTest
    @MethodSource("provideNameResult")
    void test_constructor_of(String name) {
        assertThat(Participant.of(name))
                .isEqualTo(Participant.of(name));
    }

    @DisplayName("Overrided toString ")
    @ParameterizedTest
    @MethodSource("provideNameResult")
    void test_toString(String name) {
        assertThat(Participant.of(name).toString())
                .isEqualTo(name);
    }
}
