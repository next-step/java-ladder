package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.reword.Rewords;
import nextstep.ladder.domain.player.Player;

public class LadderResult {

    private final Ladder ladder;
    private final Rewords rewords;

    private LadderResult(Ladder ladder, Rewords rewords) {
        this.ladder = ladder;
        this.rewords = rewords;
    }

    public static LadderResult of(Ladder ladder, Rewords rewords) {
        return new LadderResult(ladder, rewords);
    }

    public String result(Player player) {
        Position resultPosition = ladder.move(player.position());
        return rewords.reword(resultPosition);
    }
}
