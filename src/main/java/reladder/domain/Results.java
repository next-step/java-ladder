package reladder.domain;

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

    public String getResultValue(int resultIndex) {
        return results.stream()
                .filter(result -> result.isPosition(resultIndex))
                .map(Result::getName)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int size() {
        return this.results.size();
    }

    public boolean contains(Result result) {
        return this.results.contains(result);
    }
}
