package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;

    public Results(String[] values)
    {
        this.results = Arrays.stream(values)
                .map(Result::new)
                .collect(Collectors.toList());
    }


    public List<Result> list(){
        return Collections.unmodifiableList(results);
    }

    public int size() {
        return results.size();
    }

}
