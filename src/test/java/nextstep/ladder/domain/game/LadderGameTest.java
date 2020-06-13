package nextstep.ladder.domain.game;

import nextstep.ladder.domain.ladder.DirectionRandomPredicate;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.optional.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    @MethodSource("사다리_생성")
    @ParameterizedTest
    @DisplayName("사다리 게임 생성 테스트")
    void create(Ladder ladder) {
        assertThatCode(() -> new LadderGame(ladder)).doesNotThrowAnyException();
    }

    @NullSource
    @ParameterizedTest
    @DisplayName("사다리 게임 생성 예외 테스트")
    void create_exception(Ladder ladder) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(ladder));
    }

    @MethodSource("사다리_생성")
    @ParameterizedTest
    @DisplayName("사다리 게임 실행 테스트")
    void play(Ladder ladder) {
        LadderGame ladderGame = new LadderGame(ladder);
        LadderGameResult gameResult = ladderGame.play();
    }

    private static Stream<Arguments> 사다리_생성() {
        Ladder ladder = new Ladder(Height.from(3), 3, new DirectionRandomPredicate());
        return Stream.of(Arguments.of(ladder));
    }
}
