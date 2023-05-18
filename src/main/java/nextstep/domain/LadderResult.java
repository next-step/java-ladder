package nextstep.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {

    private Ladder ladder;
    private Usernames usernames;

    public LadderResult(Ladder ladder, Usernames usernames) {
        this.ladder = ladder;
        this.usernames = usernames;
    }

    public Map<Username, String> getLadderResult(Username name, InputResults inputResults) {
        List<Integer> ladderResults = ladder.getResults();
        List<String> results = inputResults.getResults();

        if (name.equals(new Username("all"))) {
            return match(ladderResults, results);
        }

        Map<Username, String> finalResults = new LinkedHashMap<>();
        finalResults.put(name, results.get(ladder.getResult(name, usernames)));
        return finalResults;
    }

    private Map<Username, String> match(List<Integer> ladderResults, List<String> results) {
        Map<Username, String> finalResults = new LinkedHashMap<>();
        List<String> inputResults = ladderResults.stream()
                .map(results::get)
                .collect(Collectors.toList());

        for (int index = 0; index < inputResults.size(); index++) {
            finalResults.put(usernames.getUsernames().get(index), inputResults.get(index));
        }
        return finalResults;
    }
}
