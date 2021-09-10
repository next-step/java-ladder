package nextstep.ladder2.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results = new ArrayList<>();

    private Results(String results) {
        this.results = Arrays.stream(results.split(","))
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public static Results of(String results) {
        return new Results(results);
    }

    public List<String> resultValues() {
        return results.stream()
                .map(Result::price)
                .collect(Collectors.toList());
    }

    public String findResult(int index) {
        if (index == Integer.MAX_VALUE - 1) {
            return "없는 사용자 입니다.";
        }
        return this.results.get(index).price();
    }
}
