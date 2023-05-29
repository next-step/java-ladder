package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchResult {

    private final Ladder ladder;
    private Map<String, String> results = new HashMap<>();

    public MatchResult(Ladder ladder) {
        this.ladder = ladder;
    }

//    public String result(String personName) {
//        List<Person> people = ladder.people().value();
//        List<Line> lines = ladder.lines().value();
//        List<ExecuteResult> executeResults = ladder.executeResults().value();
//
//        int peopleCnt = people.size();
//        int height = lines.size();
//
//
//        return "";
//    }

    public Map<String, String> value() {
        return results;
    }
}
