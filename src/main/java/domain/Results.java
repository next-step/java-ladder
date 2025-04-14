package domain;

import java.util.List;

public class Results {
    private final List<String> values;

    public Results(List<String> values) {
        this.values = values;
    }

    public String getResultAt(int index) {
        return values.get(index);
    }

    public List<String> getValues() {
        return values;
    }
}
