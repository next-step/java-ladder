package step4.domain;

import step4.dto.LaddersDto;
import step4.dto.PlayersDto;
import step4.dto.PrizesDto;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    private LadderGame(Ladder ladder, Players players, Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public static LadderGame of(String[] names, int height, String[] inputPrizes) {
        Players players = Players.of(names);
        Ladder ladder = Ladder.of(players.playerCount(), height);
        Prizes prizes = Prizes.of(inputPrizes, names.length);
        return new LadderGame(ladder, players, prizes);
    }

    public PlayResult play() {
        PlayResult playResult = new PlayResult();
        for(Player player : players.players()) {
            Position position = player.playerPosition();
            playResult.addResult(player, prizes.matchPosition(ladder.play(position)));
        }
        return playResult;
    }

    public Player findPlayer(String playerName) {
        return players.findPlayer(playerName);
    }

    public LaddersDto toLaddersDto() {
        return new LaddersDto(this.ladder.ladderLines());
    }

    public PlayersDto toPlayersDto() {
        return new PlayersDto(this.players.players());
    }

    public PrizesDto toPrizeDto() {
        return new PrizesDto(this.prizes.prizes());
    }
}
