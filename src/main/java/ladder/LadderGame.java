package ladder;

public class LadderGame {
    public static LadderGameResults start(Ladder ladder, LadderGameInfo ladderGameInfo) {
        return ladderGameInfo.match(ladder.exec());
    }
}
