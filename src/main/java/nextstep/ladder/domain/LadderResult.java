package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private List<Integer> finalResult = new ArrayList<>();
    private List<String> results;

    public LadderResult(List<String> results) {
        this.results = results;
    }

    public String asString() {
        return results.stream()
                .collect(Collectors.joining("   ", " ", ""));
    }

    public String find(Integer i) {
        return results.get(finalResult.get(i));
    }

    public void runResult(Ladder ladder, Person persons) {
        int max_location = persons.size() - 1;
        List<Line> ladders = ladder.getLadder();
        int start = persons.size();
        int height = ladders.size();
        for (int i = 0; i < start; i++) {
            int location = i;
            for (int j = 0; j < height; j++) {
                if (ladders.get(j).getList().get(location))
                    location--;
                if (location < max_location && ladders.get(j).getList().get(location + 1))
                    location++;
            }
            finalResult.add(location);
        }
    }

    public int size() {
        return finalResult.size();
    }
}
