package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private String value;

    public Result(String value) {
        this.value = value;
    }

    public static List<Result> getResults(String names) {
        return Arrays.stream(names.split(","))
                .map(Result::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Result{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public static Result getExecuteResult(String name, List<Participant> participants, List<Line> lines, List<Result> results) {

        Participant participant = Participant.findByName(name, participants);
        int idx = participants.indexOf(participant);
        Positive resultIdx = Ladder.move(lines, Positive.of(idx), Positive.of(lines.size()));
        Result result = results.get(resultIdx.getNum());

        return result;
    }
}
