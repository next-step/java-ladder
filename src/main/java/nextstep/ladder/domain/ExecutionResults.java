package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExecutionResults {

    private final List<Destination> destinations;
    public ExecutionResults(String str) {
        this(str.split(","));
    }

    public ExecutionResults(String[] executionResults) {
        this(Arrays.stream(executionResults)
                .map(Destination::new)
                .collect(Collectors.toList()));
    }

    public ExecutionResults(List<Destination> destinations) {
        if(destinations == null || destinations.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.destinations = destinations;
    }

    public void validateSize(Participants participants){
        if(this.destinations.size() != participants.getSize()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExecutionResults)) return false;
        ExecutionResults that = (ExecutionResults) o;
        return Objects.equals(destinations, that.destinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations);
    }

    public Destination getByOrder(int i) {
        return this.destinations.get(i);
    }

    public List<Destination> getExecutionResults() {
        return destinations;
    }
}
