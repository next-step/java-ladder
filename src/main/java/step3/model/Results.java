package step3.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {

    private final List<Prize> prizes;
    private static final String ALL = "all";

    public Results(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<String> particularPlayerPrize(int userIndex, LadderGame ladderGame, List<Prize> prizes) {
        return List.of(prizes.get(ladderGame.move(userIndex)).getValue());
    }

    public List<String> getLadderResult(String playerName, List<Player> players, LadderGame ladderGame, Results result) {
        if (ALL.equals(playerName)) {
            return allLadderResult(players, ladderGame);
        }

        return particularPlayerPrize(getPlayerPosition(playerName, players), ladderGame, result.getPrizes());
    }

    public List<String> allLadderResult(List<Player> players, LadderGame ladderGame) {
        return IntStream.range(0, players.size())
                .mapToObj(index -> players.get(index) + " : " + this.prizes.get(ladderGame.move(index)).getValue())
                .collect(Collectors.toList());
    }

    private int getPlayerPosition(String playerName, List<Player> players) {
        return IntStream.range(0, players.size())
                .filter(i -> Objects.equals(players.get(i).getName(), playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사다리 게임 참여자가 아닙니다."));
    }

    public List<Prize> getPrizes() {
        return this.prizes;
    }
}
