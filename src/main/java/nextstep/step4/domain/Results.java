package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Results {

    private static final String COMMA = ",";
    private static final int ZERO = 0;

    private final List<Result> resultList;

    public Results(List<Result> resultList) {
        this.resultList = resultList;
    }

    public static Results initResults(String results) {
        String[] split = results.split(COMMA);

        List<Result> resultList = new ArrayList<>(split.length);

        int index = ZERO;
        for(String result : split) {
            resultList.add(Result.of(index++, result));
        }

        return new Results(resultList);
    }

    public static Results from(List<Result> resultList) {
        return new Results(resultList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results = (Results) o;
        return Objects.equals(resultList, results.resultList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultList);
    }
}
