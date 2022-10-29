package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StickTest {

    @DisplayName("생성할 때")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class Create {

        @DisplayName("스틱 유무를 전락에 따라 정할 수 있다.")
        @ParameterizedTest
        @MethodSource("generateStickStrategy")
        void create_by_strategy(DetermineStick determineStick, Stick expected) {
            Stick actual = new Stick(determineStick);

            assertThat(actual).isEqualTo(expected);
        }

        private Stream<Arguments> generateStickStrategy() {
            return Stream.of(
                    Arguments.arguments((DetermineStick) () -> true, new Stick(true)),
                    Arguments.arguments((DetermineStick) () -> false, new Stick(false))
            );
        }
    }
}