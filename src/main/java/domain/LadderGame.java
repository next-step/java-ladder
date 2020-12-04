package domain;

import dto.InputDto;

public class LadderGame {
    private PlayerNames playerNames;
    private Ladder ladder;
    private GameResults gameResults;

    private LadderGame(final PlayerNames playerNames, final Ladder ladder, final GameResults gameResults) {
        this.playerNames = playerNames;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    public static LadderGame of(final InputDto inputDto) {
        PlayerNames playerNames = PlayerNames.of(inputDto.getNames());
        GameResults gameResults= GameResults.of(inputDto.getResults());

        Length height = Length.of(inputDto.getLadderHeight());
        Length width = Length.of(playerNames.size());
        Ladder ladder = Ladder.of(width, height);

        return new LadderGame(playerNames, ladder, gameResults);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }

    public GameResults getGameResults() { return gameResults; }

    private int play(final int start) {
        return ladder.departsAt(Position.of(start)).value();
    }

    public String fetchResultOf(final String name) {
        int index = play(playerNames.indexOf(name));
        return gameResults.get(index);
    }

    public ResultMap fetchAllResults() {
        ResultMap resultMap = ResultMap.create();
        for(int i = 0; i < playerNames.size(); i++) {
            resultMap.put(playerNames.get(i), gameResults.get(play(i)));
        }

        return resultMap;
    }
}
