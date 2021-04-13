package step3;

import step3.domain.ExecutionResult;
import step3.domain.Person;

import java.util.*;

public class Result {
    private static final String NOT_EXIST_NAME = "존재하지 않는 이름입니다.";
    private final Map<Person, ExecutionResult> resultMap;

    public Result(Map<Person, ExecutionResult> resultMap) {
        this.resultMap = resultMap;
    }

    public ExecutionResult get(Person person) {
        validation(person);
        return resultMap.get(person);
    }

    private void validation(Person person) {
        if (!resultMap.containsKey(person)) {
            throw new IllegalArgumentException(NOT_EXIST_NAME);
        }
    }

    public Collection<ExecutionResult> all() {
        return resultMap.values();
    }

    public Map<Person, ExecutionResult> of() {
        return resultMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(resultMap, result.resultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultMap);
    }
}
