package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
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

    public static ExecutionResultMap of(Persons persons, ExecutionResults executionResults, Ladder ladder) {
        return IntStream.range(0, persons.getCountOfPerson())
                .mapToObj(Integer::new)
                .collect(Collector.of(
                        ExecutionResultMap::new,
                        (executionResultMap, index) -> {
                            int resultIndex = ladder.getResultIndex(index);
                            executionResultMap.add(persons.getPerson(index), executionResults.getExecutionResult(resultIndex));
                        },
                        (a, b) -> {
                            throw new UnsupportedOperationException();
                        }
                ));
    }

    private void add(Person person, String executionResult) {
        this.executionResultMap.put(person.toString(), executionResult);
    }

    public String getExecutionResult(String personName) {
        String executionResult = executionResultMap.get(personName);
        if (executionResult == null) {
            throw new RuntimeException("참여하지 않은 사람은 입력할 수 없습니다.");
        }
        return executionResult;
    }

    public Map<String, String> getExecutionResultMap() {
        return Collections.unmodifiableMap(executionResultMap);
    }
}
