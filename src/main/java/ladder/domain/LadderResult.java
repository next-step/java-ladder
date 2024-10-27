package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private static final String RESULT_ERROR_MESSAGE = "입력한 실행 결과 수가 참여자 수를 초과했습니다.";

    private final Map<Integer, String> results;

    public LadderResult(Persons persons, String results) {
        this(persons, split(results));
    }

    public LadderResult(Persons persons, String[] results) {
        this(parse(isValid(persons, results)));
    }

    public LadderResult(Map<Integer, String> results) {
        this.results = results;
    }

    public static LadderResult from(Persons persons, String results) {

        return new LadderResult(persons, results);
    }

    private static String[] split(String results) {
        return results.split(",");
    }


    private static Map<Integer, String> parse(String[] results) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < results.length; i++) {
            map.put(i, results[i]);
        }

        return map;
    }

    private static String[] isValid(Persons persons, String[] results) {
        if (persons.getSize() == results.length) {
            return results;
        }
        throw new IllegalArgumentException(RESULT_ERROR_MESSAGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "LadderResult{" +
                "results=" + results +
                '}';
    }

}
