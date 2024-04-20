package nextstep.ladder.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private List<String> results;

    private LadderResult(List<String> results) {
        this.results = results;
    }

    public static LadderResult of(String... result) {
        return new LadderResult(
            Arrays.stream(result)
                .collect(Collectors.toList())
        );
    }


    public String getResult(int index){
        return results.get(index);
    }
}
