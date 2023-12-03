package nextstep.ladder.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
        if (results.resultSize() != ladder.peopleCount()) {
            throw new IllegalArgumentException("실행 결과 수는 총 사람수와 같아야 합니다");
        }

    }

    public GameResult playGame(){
        Map<String, String> resultMap = new LinkedHashMap<>();
        List<Integer> finalPeopleArrived = ladder.finalPeopleArrived();
        for (int peopleNumber = 0; peopleNumber < ladder.peopleCount(); peopleNumber++) {
            String result = results.results(finalPeopleArrived.get(peopleNumber));
            resultMap.put(ladder.personName(peopleNumber), result);
        }
        return new GameResult(resultMap);
    }

}
