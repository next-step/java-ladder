package nextstep.ladder.domain.game;

import nextstep.ladder.domain.ladder.DirectionRandomPredicate;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
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
    @DisplayName("사다리 게임 one user 실행 테스트")
    void play(Ladder ladder) {
        LadderGame ladderGame = new LadderGame(ladder);
        List<User> users = Arrays.asList(User.newInstance("ray", Order.from(0)));

        LadderGameResult gameResult = ladderGame.play(users);
        assertThat(gameResult).isNotNull();
    }

    @MethodSource("사다리_생성")
    @ParameterizedTest
    @DisplayName("사다리 게임 user가 null 일 때 실행 테스트")
    void play_null_use_exception(Ladder ladder) {
        LadderGame ladderGame = new LadderGame(ladder);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderGame.play(null));
    }

    @MethodSource("사다리_생성")
    @ParameterizedTest
    @DisplayName("사다리 게임 user의 순서가 최대 위치보다 같거나 크면 예외 발생 테스트")
    void play_user_order_exception(Ladder ladder) {
        LadderGame ladderGame = new LadderGame(ladder);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderGame.play(Arrays.asList(User.newInstance("ray", Order.from(3)))));
    }

    private static Stream<Arguments> 사다리_생성() {
        Ladder ladder = new Ladder(Height.from(3), 3, new DirectionRandomPredicate());
        return Stream.of(Arguments.of(ladder));
    }
}
