package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(String ... titles) {
        return Stream.of(titles)
                .map(Result::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Results::new));
    }

    public static Results of(List<String> titles) {
        return titles.stream()
                .map(Result::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Results::new));
    }

    public int getNumberOfResults() {
        return results.size();
    }

    public Result getResultOfPosition(int position) {
        return results.get(position);
    }

    public List<String> getTitles() {
        return results.stream()
                .map(Result::getTitle)
                .collect(Collectors.toList());
    }

}
