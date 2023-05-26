package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Results implements Iterable<String> {

    private final List<String> values;

    public Results(List<String> values) {
        this.values = values;
    }

    public static Results create(String[] values, int countOfPerson) {
        if (values.length != countOfPerson) {
            throw new IllegalArgumentException("결과와 사람의 수는 똑같아야 합니다.");
        }

        return new Results(List.of(values));

    }

    public String get(int index) {
        return values.get(index);
    }

    @Override
    public Iterator<String> iterator() {
        return values.iterator();
    }

}
