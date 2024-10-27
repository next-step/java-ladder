package nextstep.ladder.v2.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private PlayerGroup playerGroup;
    private Ladder ladder;

    public LadderGame(List<String> names, Ladder ladder) {
        this.playerGroup = new PlayerGroup(names);
        this.ladder = ladder;
    }

    public PlayerGroup getPlayerGroup() {
        return playerGroup;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderResult createLadderResult(List<String> prizeInput) {
        if (this.playerGroup.getPlayers().size() != prizeInput.size()) {
            throw new IllegalArgumentException("Number of prizes does not match to the number of players");
        }

        List<Prize> finalPrizes = IntStream.range(0, this.playerGroup.getSize())
                .mapToObj(i -> prizeInput.get(this.ladder.move(i)))
                .map(Prize::new)
                .collect(Collectors.toList());

        return LadderResult.of(this.playerGroup.getPlayers(), finalPrizes);
    }
}
