package ladder.model;

public class Ladder {

    private final LadderLines lines;
    private final LadderGameRewords ladderGameRewords;

    private Ladder(final LadderLines lines, final LadderGameRewords ladderGameRewords) {
        validate(lines, ladderGameRewords);
        this.lines = lines;
        this.ladderGameRewords = ladderGameRewords;
    }

    private void validate(final LadderLines lines, final LadderGameRewords ladderGameRewords) {
        if (lines.getPoleCount() == ladderGameRewords.count()) {
            throw new IllegalArgumentException("Ladder pole size is not same as Ladder game rewords.");
        }
    }

    public static Ladder newInstance(final int count, final int height, final String rewords) {
        return newInstance(MemberCount.of(count), LadderHeight.newInstance(height), LadderGameRewords.newInstance(rewords));
    }

    public static Ladder newInstance(final MemberCount memberCount, final LadderHeight ladderHeight, final LadderGameRewords ladderGameRewords) {
        return new Ladder(LadderLines.newInstance(memberCount, ladderHeight), ladderGameRewords);
    }

    public int getPoleCount() {
        return lines.getPoleCount();
    }

    public LadderGameResult proceed(Members members) {
        MemberPolePosition memberPoleLastPosition = lines.proceed(members);

        return LadderGameResult.newInstance(memberPoleLastPosition, ladderGameRewords);
    }
}
