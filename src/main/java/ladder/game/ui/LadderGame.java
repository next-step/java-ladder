package ladder.game.ui;

import ladder.game.domain.LadderGameInfo;
import ladder.game.domain.LadderGameResults;
import ladder.ladder.domain.Index;
import ladder.ladder.domain.Ladder;
import ladder.player.domain.Players;
import ladder.prize.domain.Prize;
import ladder.prize.domain.Prizes;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class LadderGame {
    private final Ladder ladder;
    private final LadderGameInfo ladderGameInfo;

    private LadderGame(Ladder ladder, LadderGameInfo ladderGameInfo) {
        this.ladder = ladder;
        this.ladderGameInfo = ladderGameInfo;
    }

    public static LadderGame init(LadderGameInfo ladderGameInfo, int height) {
        Ladder ladder = Ladder.init(height, ladderGameInfo.size());
        return new LadderGame(ladder, ladderGameInfo);
    }

    public static LadderGame of(Ladder ladder, LadderGameInfo ladderGameInfo) {
        return new LadderGame(ladder, ladderGameInfo);
    }

    public LadderGameResults play() {
        return LadderGameResults.of(IntStream.range(0, ladderGameInfo.size())
                .boxed()
                .collect(toMap(ladderGameInfo::getPlayer, this::findPrizeByStartIndex)));
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return ladderGameInfo.getPlayers();
    }

    public Prizes getPrizes() {
        return ladderGameInfo.getPrizes();
    }

    private Prize findPrizeByStartIndex(int startIndex) {
        Index resultIndex = ladder.move(Index.of(startIndex));
        return ladderGameInfo.getResult(resultIndex.getIndex());
    }
}
