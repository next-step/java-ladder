package ladder.domain.game;

import ladder.domain.ladderMap.LadderMap;
import ladder.domain.participant.ParticipantList;
import ladder.domain.result.ResultList;

import java.util.List;

public class Game {
    private LadderMap ladderMap;
    private ResultList resultList;

    public Game(LadderMap ladderMap, ResultList resultList) {
        this.ladderMap = ladderMap;
        this.resultList = resultList;
    }

    public GameResult run() {
        List<Integer> resultIndices = ladderMap.traverse();
        ResultList mappedResult = new ResultList(this.resultList, resultIndices);
        ParticipantList participants = ladderMap.participantList();
        return new GameResult(participants, mappedResult);
    }

    public LadderMap ladderMap() {
        return this.ladderMap;
    }

    public ResultList resultList() {
        return this.resultList;
    }
}
