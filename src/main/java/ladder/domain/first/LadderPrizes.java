package ladder.domain.first;

import ladder.domain.PlayerName;
import ladder.domain.Players;
import ladder.engine.LadderCreator;
import ladder.engine.LadderResult;
import ladder.engine.LineCreator;
import ladder.factory.LadderResultFactory;

import java.util.*;

public class LadderPrizes implements LadderResult {
    private final List<String> prizes;

    public LadderPrizes(String prizeNames) {
        this(LadderResultFactory.splitPrizes(prizeNames));
    }

    LadderPrizes(List<String> prizes) {
        this.prizes = prizes;
    }

    @Override
    public Players result(Players players, LadderCreator ladderCreator) {
        List<? extends LineCreator> lines = ladderCreator.getLines();
        for (int maxLadderSize = lines.size() - 1; maxLadderSize >= 0; maxLadderSize--) {
            HorizontalLines horizontalLines = (HorizontalLines) lines.get(maxLadderSize);
            changePositionByLine(horizontalLines);
        }

        int index = 0;
        Map<PlayerName, String> playerMap = players.getPlayers();
        for (PlayerName playerName : playerMap.keySet()) {
            playerMap.put(playerName, prizes.get(index++));
        }

        return players;
    }

    private void changePositionByLine(HorizontalLines horizontalLines) {
        List<Boolean> connectingLines = horizontalLines.getConnectingLines();
        for (int lineIndex = 0; lineIndex < connectingLines.size(); lineIndex++) {
            changePosition(connectingLines, lineIndex);
        }
    }

    private void changePosition(List<Boolean> connectingLines, int lineIndex) {
        String temp;
        if (connectingLines.get(lineIndex)) {
            temp = prizes.get(lineIndex);
            prizes.set(lineIndex, prizes.get(lineIndex + 1));
            prizes.set(lineIndex + 1, temp);
        }
    }
}