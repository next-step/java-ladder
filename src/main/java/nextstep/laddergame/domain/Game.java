package nextstep.laddergame.domain;

import java.util.List;

public class Game {
    private final List<Gamer> gamers;
    private final Ladder ladder;

    public Ladder getLadder() {
        return ladder;
    }

    public List<Gamer> getGamers() {
        return gamers;
    }

    public Game(List<Gamer> gamers, Height ladderHeight, BridgeInterface bridgeInterface) {
        this.gamers = gamers;
        this.ladder = new Ladder(gamers.size(), ladderHeight, bridgeInterface);
    }
}
