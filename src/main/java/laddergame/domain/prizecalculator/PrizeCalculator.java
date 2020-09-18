package laddergame.domain.prizecalculator;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.navigator.Navigator;
import laddergame.domain.player.Player;
import laddergame.domain.prize.Prize;

import java.util.List;
import java.util.stream.Collectors;

public class PrizeCalculator {

    private List<Prize> prizes;
    private Ladder ladder;

    public PrizeCalculator(List<Prize> prizes, Ladder ladder) {
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public Player calculateSinglePrize(Player player) {
        int initialPosition = player.getPosition();
        ladder.getLines().forEach(line -> Navigator.movePlayer(line, player));
        player.takePrize(prizes.get(player.getPosition()).getContent());
        player.initPosition(initialPosition);
        return player;
    }

    public List<Player> calculateTotalPrizes(List<Player> players) {
        return players.stream().map(this::calculateSinglePrize).collect(Collectors.toList());
    }

}
