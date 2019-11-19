package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private List<Result> results;

    public Results(String giveawayNames) {
        this.results = createResults(giveawayNames);
    }

    private List<Result> createResults(String giveawayNames) {
        List<Result> results = new ArrayList<>();
        Names names = new Names(giveawayNames);
        for (int i = 0; i < names.length(); i++) {
            results.add(new Result(names.getName(i), i));
        }
        return new ArrayList<>(results);
    }

    String getResultValue(int resultIndex) {
        return results.stream()
                .filter(result -> result.isPosition(resultIndex))
                .map(Result::getName)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    int size() {
        return this.results.size();
    }

    public List<Result> getResults() {
        return new ArrayList<>(results);
    }
}
