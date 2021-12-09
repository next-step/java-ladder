package ladder.model.result;

import java.util.*;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(String results, int playerCount)  {
        this.results = Arrays.stream(results.split(","))
                            .map(Result::new)
                            .collect(Collectors.toList());
        checkValidation(this.results, playerCount);
    }

    public List<Result> get() {
        return Collections.unmodifiableList(this.results);
    }

    public Result get(int index) {
        return this.results.get(index);
    }

    private void checkValidation(List<Result> results, int playerCount) {
        if(results.size() != playerCount) {
            throw new IllegalArgumentException("실행 결과의 수는 참여하는 사람 수와 같아야 합니다.");
        }
    }
}
