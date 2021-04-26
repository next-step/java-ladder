package nextstep.model;

import static nextstep.constant.Constant.ALL;

public class OnlineLadder extends Ladder {
    private final Lines lines;
    private final Players players;
    private final LadderResult ladderResult;
    private String[] result;

    public OnlineLadder(int maxVertical, int countOfPerson, String[] names, String resultString) {
        this.lines = new Lines(maxVertical, countOfPerson);
        this.players = new Players(names);
        this.lineMarkAll();
        this.result = resultString.split(",");
        ladderResult = new LadderResult(names, resultString);
    }

    public void lineMarkAll() {
        this.lines.initMark();
        this.lines.markWithoutFirst();
    }

    public Points points(int row) {
        return this.lines.points(row);
    }

    public Players players() {
        return players;
    }

    public LadderResult start(Player whoWinner) {
        if (whoWinner.player().equalsIgnoreCase(ALL)) {
            for (Player player : this.players.players()) {
                draw(player);
            }
            return this.ladderResult;
        }
        draw(whoWinner);
        return ladderResult;
    }

    private void draw(Player player) {
        int playerIndex = this.filterByPlayerName(player);
        if (playerIndex < 0) {
            throw new IllegalArgumentException("No user");
        }
        int playerResult = this.lines.start(playerIndex);
        this.ladderResult.addValue(player, result[playerResult]);
    }

    public int filterByPlayerName(Player playerName) {
        return this.players.filterResultIndex(playerName);
    }
}
