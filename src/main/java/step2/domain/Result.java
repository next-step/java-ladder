package step2.domain;

import step2.dto.Player;

import java.util.Objects;

public class Result {
    private final Player player;
    private final int resultIndex;

    public Result(Player player, int resultIndex) {
        this.player = player;
        this.resultIndex = resultIndex;
    }

    public boolean isPlayer(Player name) {
        return this.player.equals(name);
    }

    public String print(ExecutionResults executionResults) {
        return executionResults.findExecutionResult(resultIndex);
    }

    public String printAll(ExecutionResults executionResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(player.print())
                .append(" : ")
                .append(executionResults.findExecutionResult(resultIndex))
                .append("\n");
        return stringBuilder.toString();
    }


    @Override
    public String toString() {
        return "Result{" +
                "player=" + player +
                ", resultIndex=" + resultIndex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return resultIndex == result.resultIndex && Objects.equals(player, result.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, resultIndex);
    }
}
