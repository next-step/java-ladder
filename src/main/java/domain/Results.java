package domain;

import lombok.Getter;

import java.util.List;

public class Results {
    private List<Result> results;

    @Getter
    private int number;

    public Results(List<Result> list) {
        this.results = list;
        this.number = list.size();
    }

    @Override
    public String toString() {
        return results.toString() +
                "  ";
    }

    public Result get(int i) {
        return results.get(i);
    }
}
