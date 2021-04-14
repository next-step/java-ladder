package step4.domain;

import step4.dto.LaddersDto;
import step4.dto.PlayersDto;

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

    public LaddersDto toLaddersDto() {
        return new LaddersDto(this.ladder.ladderLines());
    }

    public PlayersDto toPlayersDto() {
        return new PlayersDto(this.players.players());
    }
}
