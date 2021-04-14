package step4.domain;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    private LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public static LadderGame of(String[] names, int height) {
        Players players = Players.of(names);
        Ladder ladder = Ladder.of(players.playerCount(), height);
        return new LadderGame(ladder, players);
    }

    public PlayResult play(Prizes prizes) {
        PlayResult playResult = new PlayResult();
        for(Player player : players.players()) {
            Position position = player.playerPosition();
            playResult.addResult(player, prizes.matchPosition(ladder.play(position)));
        }
        return playResult;
    }
}
