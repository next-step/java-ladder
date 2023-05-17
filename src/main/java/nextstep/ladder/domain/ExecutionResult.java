package nextstep.ladder.domain;

import nextstep.ladder.dto.ExecutionResultDto;
import nextstep.ladder.dto.GamerDto;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExecutionResult {

    private final Map<String, String> results;

    public ExecutionResult(Map<String, String> results) {
        this.results = results;
    }

    public static ExecutionResult of(Gamers climbedGamers, List<String> results) {
        List<GamerDto> gamers = climbedGamers.toDto().getGamers();
        return gamers.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                GamerDto::getName,
                                gamerDto -> results.get(gamerDto.getPosition())),
                        ExecutionResult::new));
    }

    public ExecutionResultDto toDto() {
        return ExecutionResultDto.of(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionResult result = (ExecutionResult) o;
        return Objects.equals(results, result.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
