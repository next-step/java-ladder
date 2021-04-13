package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class ExecutionResultMap {
    private Map<String, String> executionResultMap;

    private ExecutionResultMap() {
        this(new LinkedHashMap<>());
    }

    private ExecutionResultMap(final Map<String, String> executionResultMap) {
        this.executionResultMap = executionResultMap;
    }

    public static ExecutionResultMap of(Persons persons, LadderExecutionResults ladderExecutionResults) {
        return IntStream.range(0, persons.getCountOfPerson())
                .boxed()
                .collect(Collector.of(
                        ExecutionResultMap::new,
                        (executionResultMap, index) ->
                                executionResultMap.add(
                                        persons.getPerson(index),
                                        ladderExecutionResults.getExecutionResult(index)),
                        (a, b) -> {
                            throw new UnsupportedOperationException();
                        }
                ));
    }

    private void add(Person person, String executionResult) {
        this.executionResultMap.put(person.toString(), executionResult);
    }

    public String getExecutionResult(String personName) {
        String executionResult = Optional.ofNullable(executionResultMap.get(personName))
                                         .orElseThrow(() ->
                                                 new RuntimeException("참여하지 않은 사람은 입력할 수 없습니다."));
        return executionResult;
    }

    public Map<String, String> getExecutionResultMap() {
        return Collections.unmodifiableMap(executionResultMap);
    }
}
