package nextstep.laddergame.domain;

import nextstep.laddergame.wrapper.Height;
import nextstep.laddergame.wrapper.Participants;

import java.util.ArrayList;
import java.util.List;

public class Game implements LadderGameInterface {
    private final Participants participants;
    private final Ladder ladder;

    public List<Line> getLadderLines() {
        return this.ladder.getLines();
    }

    public Game(Participants participants, Height ladderHeight, BridgeInterface bridgeInterface) {
        this.participants = participants;
        this.ladder = new Ladder(participants.getNumberOfPerson(), ladderHeight, bridgeInterface);
    }

    public Gamer getGamer(String name) {
        return this.participants.getGamer(name);
    }

    public Gamer getGamer(int index) {
        return this.participants.getGamer(index);
    }

    public List<Gamer> getGamers() {
        return this.participants.getGamers();
    }

    @Override
    public int getResultIndex(int startIndex) {
        Line startLine = ladder.getStartLine();
        LadderPiece startLadderPiece = startLine.getLadderPiece(startIndex);
        return startLadderPiece.moveToLadder(startIndex);
    }

    @Override
    public List<Integer> getResultAll() {
        List<Integer> resultIndexes = new ArrayList<>();
        Line startLine = ladder.getStartLine();
        for (Gamer gamer : this.participants.getGamers()) {
            int index = gamer.getIndex();
            LadderPiece startLadderPiece = startLine.getLadderPiece(index);
            resultIndexes.add(startLadderPiece.moveToLadder(index));
        }
        return resultIndexes;
    }
}
