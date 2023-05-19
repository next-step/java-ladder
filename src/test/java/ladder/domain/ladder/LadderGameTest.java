package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.Test;

class LadderGameTest {

  @Test
  void 사다리_게임_플레이_결과_검증() {
    Participants participants = new Participants("a", "b", "c");

    Point first = Point.of(0, false, true);
    Point second = Point.of(1, true, false);
    Point last = Point.of(2, false, false);

    Ladder ladder = new Ladder(new Line(first, second, last));

    Prizes prizes = new Prizes("꽝", "5000", "꽝");
    LadderGame ladderGame = new LadderGame(ladder, participants);

    MatchResults matchResults = ladderGame.play(prizes);

    assertThat(matchResults.getResult(new Name("a"))).isEqualTo(new Prize("5000"));
    assertThat(matchResults.getResult(new Name("b"))).isEqualTo(new Prize("꽝"));
  }
}