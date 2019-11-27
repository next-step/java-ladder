package reladder;

import reladder.domain.Ladder;
import reladder.domain.LadderGenerator;
import reladder.domain.MatchUp;
import reladder.service.LadderGame;
import reladder.service.LadderGameResult;

import java.util.Map;

public class LadderRequest {

    public MatchUp requestMatchUp(String names, String results) {
        return new MatchUp(names, results);
    }

    public Ladder requestLadder(int height, MatchUp matchUp, LadderGenerator ladderGenerator) {
        return ladderGenerator.generate(height, matchUp.getPeopleCount());
    }

    public LadderGame requestLadderGame(Ladder ladder, MatchUp matchUp) {
        return new LadderGame(ladder, matchUp);
    }

    public String requestGameResult(LadderGame ladderGame, String name) {
        return new LadderGameResult(ladderGame).getResult(name);
    }

    public Map<String, Object> requestGameResultAll(LadderGame ladderGame) {
        return new LadderGameResult(ladderGame).getResultAll();
    }
}
