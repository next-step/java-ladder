package step2.domain;

import step2.dto.Player;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public Result findResult(Player player) {
        return results.stream()
                .filter(result -> result.isPlayer(player))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("결과를 찾을 수 없습니다."));
    }

    public String print(String targetName, ExecutionResults executionResults) {
        if (targetName.equals("all")) {
            return this.printAll(executionResults);
        }
        final Result findResult = results.stream()
                .filter(result -> result.isPlayer(new Player(targetName)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("%s에 해당하는 Player를 찾을 수 없습니다.", targetName)
                ));

        return findResult.print(executionResults);
    }

    public String printAll(ExecutionResults executionResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Result result : results) {
            stringBuilder.append(result.printAll(executionResults));
        }
        return stringBuilder.toString();
    }


    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                '}';
    }
}
