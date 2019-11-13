package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private static final String ALL_PRINT_STRING = "all";

    private List<UserRecord> records;

    public GameResult(List<UserRecord> records) {
        this.records = records;
    }

    public List<String> findOutcome(String inputValue) {
        if(ALL_PRINT_STRING.equals(inputValue)) {
            return findAll();
        }

        return Collections.singletonList(findOne(inputValue));
    }

    private String findOne(String inputValue) {
        return records.stream()
                .filter(r -> r.isUser(inputValue))
                .map(UserRecord::getOutcome)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결과를 찾을 수 없습니다."));
    }

    private List<String> findAll() {
        return records.stream()
                .map(UserRecord::getResultFormat)
                .collect(Collectors.toList());
    }
}
