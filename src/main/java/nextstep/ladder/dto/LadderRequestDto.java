package nextstep.ladder.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderRequestDto {
    private final int MIN_USER_SIZE = 2;
    private final int MIN_HEIGHT = 2;
    private final static String BLANK = "꽝";

    private final List<String> names;
    private final int height;
    private final List<String> results;

    public LadderRequestDto(List<String> names, List<String> results, int height) {
        this.validateHeight(height);
        this.validateNames(names);
        results.stream()
                .forEach(result -> this.validateResult(result));
        this.validateNameAndResult(names, results);
        this.names = Collections.unmodifiableList(names);
        this.results = Collections.unmodifiableList(results);
        this.height = height;
    }

    public List<String> getNames() {
        return this.names;
    }

    public int getHeight() {
        return this.height;
    }

    public List<String> getResults() {
        return this.results;
    }

    private void validateNames(List<String> names) {
        if (Objects.isNull(names) || names.size() < MIN_USER_SIZE) {
            throw new IllegalArgumentException(String.format("name is at least %d", MIN_USER_SIZE));
        }
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("height is at least %d", MIN_HEIGHT));
        }
    }

    private void validateResult(String result) {
        if (Objects.isNull(result) || result.isEmpty()) {
            throw new IllegalArgumentException("result is required");
        }

        if (!result.equals(BLANK)) {
            this.isNumber(result);
        }
    }

    private void isNumber(String result) {
        try {
            Integer.parseInt(result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("not valid result");
        }
    }

    private void validateNameAndResult(List<String> names, List<String> results) {
        if (names.size() != results.size()) {
            throw new IllegalArgumentException("name size should be the same results size");
        }
    }
}
