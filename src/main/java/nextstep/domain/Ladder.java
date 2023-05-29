package nextstep.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Map<Username, String> result;

    public Ladder(Lines lines, Usernames usernames, InputResults inputResults) {
        result = toLadderResult(lines, usernames, inputResults);
    }

    private Map<Username, String> toLadderResult(Lines lines,
                                                 Usernames usernames,
                                                 InputResults inputResults) {
        List<Integer> ladderResults = play(lines, usernames.size());
        List<String> results = inputResults.getResults();
        return match(ladderResults, results, usernames);
    }

    private List<Integer> play(Lines lines, int userCount) {
        return IntStream.range(0, userCount)
                .map(lines::findDestination)
                .boxed()
                .collect(Collectors.toList());
    }

    private Map<Username, String> match(List<Integer> ladderResults,
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

    public Map<Username, String> getResult(Username name) {
        if (name.equals(Username.ALL)) {
            return result;
        }
        return Map.of(name, result.get(name));
    }
}
