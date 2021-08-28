package nextstep.ladder.domain;

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

    public String resultByName(String name) {
        Player player = ladder.findPlayerByName(name);
        ladder.movePlayer(player);
        return rewords.reword(player);
    }
}
