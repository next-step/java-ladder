package net.chandol.ladder.v2.domain;

import net.chandol.ladder.v2.domain.line.Lines;
import net.chandol.ladder.v2.domain.line.LinesGenerator;
import net.chandol.ladder.v2.domain.player.Player;
import net.chandol.ladder.v2.domain.player.Players;
import net.chandol.ladder.v2.domain.prize.Prize;
import net.chandol.ladder.v2.domain.prize.Prizes;
import net.chandol.ladder.v2.dto.LadderGameResult;
import net.chandol.ladder.v2.dto.LadderInitializeRequest;

public class Ladder {
    private Lines lines;
    private Players players;
    private Prizes prizes;

    public Ladder(LadderInitializeRequest request, LinesGenerator linesGenerator) {
        this.players = request.getPlayers();
        this.prizes = request.getPrizes();
        this.lines = linesGenerator.generate(players.size(), request.getHeight());
    }

    public boolean hasPoint(int column, int row) {
        return lines.hasPoint(column, row);
    }

    public String createLadderString() {
        String playersStr = players.createPlayersString();
        String linesStr = String.join("\n", lines.createLinesString());
        String prizesStr = prizes.createPrizesString();

        return playersStr + "\n" + linesStr + "\n" + prizesStr;
    }

    public LadderGameResult createGameResult() {
        LadderGameResult gameResult = new LadderGameResult();
        for (int idx = 0; idx < players.size(); idx++) {
            int resultLine = lines.calculateResult(idx);

            Player player = players.getPlayer(idx);
            Prize prize = prizes.getPrize(resultLine);

            gameResult.add(player, prize);
        }

        return gameResult;
    }
}
