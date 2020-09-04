package step2.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    List<Boolean> branch;

    public Line(int countOfPerson) {
        branch = Stream
                .iterate(false, n -> n)
                .limit(countOfPerson)
                .collect(Collectors.toList());
    }


    public String printBranches() {
        return branch.toString();
    }
}
