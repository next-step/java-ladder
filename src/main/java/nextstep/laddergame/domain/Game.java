package nextstep.laddergame.domain;

import nextstep.laddergame.wrapper.Height;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Gamer> gamers;
    private final Ladder ladder;

    public Ladder getLadder() {
        return ladder;
    }

    public List<Line> getLadderLines() {
        return this.ladder.getLines();
    }

    public List<Gamer> getGamers() {
        return gamers;
    }

    public Game(List<Gamer> gamers, Height ladderHeight, BridgeInterface bridgeInterface) {
        this.gamers = gamers;
        this.ladder = new Ladder(gamers.size(), ladderHeight, bridgeInterface);
    }

    public Gamer getGamer(String name) {
        return this.gamers
                .stream()
                .filter(vo -> vo.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Gamer getGamer(int index) {
        return this.gamers.get(index);
    }

    public int getResultIndex(int startIndex) {
        Line startLine = ladder.getStartLine();
        LadderPiece startLadderPiece = startLine.getLadderPiece(startIndex);
        return startLadderPiece.moveToLadder(startIndex);
    }

    public List<Integer> getResultAll() {
        List<Integer> resultIndexes = new ArrayList<>();
        Line startLine = ladder.getStartLine();
        for (Gamer gamer : gamers) {
            int index = gamer.getIndex();
            LadderPiece startLadderPiece = startLine.getLadderPiece(index);
            resultIndexes.add(startLadderPiece.moveToLadder(index));
        }
        return resultIndexes;
    }
}
