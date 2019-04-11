package domain;

import util.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private static final String SEPARATOR = ",";
    private static final String TAB_SIZE = "     ";
    private List<String> results = new ArrayList<>();

    public Result(String results, int countOfPerson) {
        if (results.split(SEPARATOR).length != countOfPerson) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH.getErrorMessage());
        }
        this.createResult(results);
    }

    private void createResult(String results) {
        this.results = Arrays.stream(results.trim().split(SEPARATOR)).collect(Collectors.toList());
    }

    public String getResult(int resultIndex) {
        return this.results.get(resultIndex).trim();
    }

    @Override
    public String toString() {
        return String.join(TAB_SIZE, this.results);
    }
}
