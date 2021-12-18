package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {
    private static final String DEFAULT_SPLIT_CHARACTER = ",";

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public Results(String... results) {
        this(toResults(results));
    }

    public Results(String results) {
        this(toResults(getResults(results)));
    }

    private static List<Result> toResults(String[] results) {
        return Arrays.stream(results)
                            .map(Result::new)
                            .collect(Collectors.toList());
    }

    private static String[] getResults(String results) {
        String[] splitMemberNames = results.split(DEFAULT_SPLIT_CHARACTER);
        return splitMemberNames;
    }

    public boolean isEqualMembersCount(Members members){
        return members.countOfMember() == results.size();
    }

    public List<Result> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
