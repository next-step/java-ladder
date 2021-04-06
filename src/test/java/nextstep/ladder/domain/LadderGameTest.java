package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {


    @DisplayName("사다리 높이가 최솟값을 만족하지 못할 경우")
    @ParameterizedTest
    @MethodSource("provideLadderHeightUnderMin")
    void ladderGame_of(int ladderHeight, String[] userName) {
        assertThatThrownBy(() -> {
            LadderGame ladderGame = LadderGame.of(ladderHeight, userName);
        }).isInstanceOf(LadderException.class)
                .hasMessage("사다리의 최소 높이는 1입니다.");
    }

    private static Stream<Arguments> provideLadderHeightUnderMin() {
        return Stream.of(
                Arguments.of(0, new String[]{"poby", "james", "john"}),
                Arguments.of(0, new String[]{"poby", "james", "john"})
        );
    }
}