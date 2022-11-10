package ladder.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.result.Award;
import ladder.result.Awards;
import ladder.result.LadderResult;
import ladder.user.Players;
import ladder.user.UserName;
import ladder.user.UserNames;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 사다리_게임_검증() {
        Row first = new Row(List.of(right(0), left(1), straight(2)));
        Row second = new Row(List.of(straight(0), right(1), left(2)));
        Row third = new Row(List.of(right(0), left(1), straight(2)));
        Ladder ladder = new Ladder(List.of(first, second, third));
        UserName playerA = new UserName("aa");
        UserName playerB = new UserName("bb");
        UserName playerC = new UserName("cc");
        Players players = new Players(new UserNames(List.of(playerA, playerB, playerC)));
        Award firstAward = new Award("꽝");
        Award secondAward = new Award("100");
        Award thirdAward = new Award("300");
        Awards awards = new Awards(List.of(firstAward, secondAward, thirdAward));

        LadderResult result = ladder.play(players, awards);
        assertThat(result.getTargetPlayer(playerA)).isEqualTo(thirdAward);
        assertThat(result.getTargetPlayer(playerB)).isEqualTo(secondAward);
        assertThat(result.getTargetPlayer(playerC)).isEqualTo(firstAward);
    }

    private Point right(int position) {
        return new Point(position, Direction.of(false, true));
    }

    private Point left(int position) {
        return new Point(position, Direction.of(true, false));
    }

    private Point straight(int position) {
        return new Point(position, Direction.of(false, false));
    }
}
