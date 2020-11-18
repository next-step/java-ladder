package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class makeLadderTest {

    @DisplayName("사다리 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderPlayersAndLadderHeight")
    void makeLadder(LadderPlayers players, int height) {
        Ladder ladder = LadderGame.makeLadder(players, height);
    }

    private static Stream<Arguments> provideLadderPlayersAndLadderHeight() {
        return Stream.of(
                Arguments.of(LadderGame.join("pobi,crong,haha,bibi"), 5)
        );
    }
}
