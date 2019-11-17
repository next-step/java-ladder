package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private static final String DELIMITER = ",";

    private List<Result> results = new ArrayList<>();

    public Results(String giveawayNames) {
        this.results = createResults(giveawayNames);
    }

    private List<Result> createResults(String giveawayNames) {
        String[] names = giveawayNames.split(DELIMITER);
        for (int i = 0; i < names.length; i++) {
            results.add(new Result(names[i], i));
        }
        return results;
    }

    public List<Result> getResults() {
        return new ArrayList<>(results);
    }
}
