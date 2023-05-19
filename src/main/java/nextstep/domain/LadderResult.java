package nextstep.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {

    private final Map<Username, String> ladderResult;

    public LadderResult(Ladder ladder, Usernames usernames, InputResults inputResults) {
        ladderResult = toLadderResult(ladder, usernames, inputResults);
    }

    private static Map<Username, String> toLadderResult(Ladder ladder,
                                                        Usernames usernames,
                                                        InputResults inputResults) {
        List<Integer> ladderResults = ladder.getResults();
        List<String> results = inputResults.getResults();
        return match(ladderResults, results, usernames);
    }

    public Map<Username, String> getLadderResult(Username name) {
        if (name.equals(new Username("all"))) {
            return ladderResult;
        }
        return new HashMap<>(){{
            this.put(name, ladderResult.get(name));
        }};
    }

    private static Map<Username, String> match(List<Integer> ladderResults,
                                               List<String> results,
                                               Usernames usernames) {
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
