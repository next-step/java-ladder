package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private List<String> results;

    public LadderResult(List<String> results) {
        this.results = results;
    }

    public String getResult(int location) {
        return results.get(location);
    }

    @Override
    public String toString() {
        return results.stream().map(result -> {
            if (result.equals("꽝")) {
                return " 꽝   ";
            }
            return " " + result + " ";
        }).collect(Collectors.joining());
    }
}
