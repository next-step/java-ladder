package nextstep.ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final Ladder ladder;
    private final Results results;

    public Game(Ladder ladder, Results results) {
        validate(ladder, results);
        this.ladder = ladder;
        this.results = results;
    }

    private void validate(Ladder ladder, Results results) {
        if (results.resultSize() > ladder.peopleCount()) {
            throw new IllegalArgumentException("실행 결과 수는 총 사람수 보다 클 수 없습니다.");
        }
    }

    public GameResult playGame(){
        Map<String, String> resultMap = new HashMap<>();
        List<Integer> finalPeopleArrived = ladder.finalPeopleArrived();
        for (int i = 0; i < ladder.peopleCount(); i++) {
            String result = results.result(finalPeopleArrived.get(i));
            resultMap.put(ladder.personName(i), result);
        }
        return new GameResult(resultMap);
    }

}
