package ladder.entity.game;

import ladder.entity.ladderMap.LadderMap;
import ladder.entity.ladderMap.Point;
import ladder.entity.participant.ParticipantList;
import ladder.entity.resultCase.ResultCaseList;

import java.util.List;

public class Game {
    private LadderMap ladderMap;
    private ResultCaseList resultCaseList;

    public Game(LadderMap ladderMap, ResultCaseList resultCaseList) {
        this.ladderMap = ladderMap;
        this.resultCaseList = resultCaseList;
    }

    public GameResult run() {
        List<Point> resultIndices = ladderMap.traverse();
        ResultCaseList mappedResult = new ResultCaseList(this.resultCaseList, resultIndices);
        ParticipantList participants = ladderMap.participantList();
        return new GameResult(participants, mappedResult);
    }

    public LadderMap ladderMap() {
        return this.ladderMap;
    }

    public ResultCaseList resultList() {
        return this.resultCaseList;
    }
}
