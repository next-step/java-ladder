package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class LadderGamePrizesTest {

    @ParameterizedTest
    @MethodSource("provideValidPrizeNames")
    @DisplayName("보상이름리스트의 수만큼 보상정보목록이 생성된다.")
    void validPrizeNames(String[] prizeNames, int expectedSize) {
        assertThat(LadderGamePrizes.from(prizeNames).count()).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @NullSource
    void nullPrizeNames(String[] prizeNames) {
        assertThatThrownBy(() -> LadderGamePrizes.from(prizeNames))
            .isInstanceOf(NullPointerException.class);
    }

    private static Stream<Arguments> provideValidPrizeNames() {
        return Stream.of(
            Arguments.of(new String[]{"꽝"}, 1),
            Arguments.of(new String[]{"꽝", "당첨"}, 2),
            Arguments.of(new String[]{"꽝", "당첨", "1000"}, 3)
        );
    }
}