package domain;

import dto.InputDto;

public class LadderGame {
    private PlayerNames playerNames;
    private Ladder ladder;
    private GameResults gameResults;

    private LadderGame(PlayerNames playerNames, Ladder ladder, GameResults gameResults) {
        this.playerNames = playerNames;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    public static LadderGame of(InputDto inputDto) {
        PlayerNames playerNames = PlayerNames.of(inputDto.getNames());

        Length height = Length.of(inputDto.getLadderHeight());
        Length width = Length.of(playerNames.size());
        Ladder ladder = Ladder.of(width, height);

        GameResults gameResults= GameResults.of(inputDto.getResults());

        return new LadderGame(playerNames, ladder, gameResults);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }

    public GameResults getGameResults() { return gameResults; }
}
