package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results {

    private List<String> values = new ArrayList<>();

    public Results(List<String> values) {
        this.values = values;
    }

    public static Results of(int countOfPerson, String[] results) {
        if (countOfPerson != results.length) {
            throw new IllegalArgumentException("참가자와 결과의 수는 동일해야합니다.");
        }
        return new Results(List.of(results));
    }

    public List<String> getValues() {
        return Collections.unmodifiableList(values);
    }

    public String getResult(int index) {
        return values.get(index);
    }
}
