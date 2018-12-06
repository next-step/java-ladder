package Ladder;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private static final String DELIMETER = ",";
    private List<Result> results = new ArrayList<>();

    public Results(String results) {
        String[] manyResult = results.split(DELIMETER);
        for (String name : manyResult) {
            this.results.add(new Result(name));
        }
    }

    public Result getOneResult(int number) {
        return results.get(number);
    }

    public int resultCounts() {
        return this.results.size();
    }

    @Override
    public String toString() {
        StringBuilder nameString = new StringBuilder();
        this.results.stream().forEach(result -> nameString.append(result.toString() + "  "));
        return nameString.toString();

    }
}
