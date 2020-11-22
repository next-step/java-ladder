package step4.domain.ladder;

import step4.domain.ladder.dto.LadderResultDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResults {
    public static final String WHITE_SPACE = " ";
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String ERROR_INVALID_PARAMETER = "유효하지 않은 결과입니다.";
    public static final String DELIMITER = ",";

    private final List<String> ladderResults;

    private LadderResults(List<String> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults of(String inputResult) {
        List<String> list = stringToList(inputResult);
        return new LadderResults(list);
    }

    public static List<String> stringToList(String inputResult) {
        isValidResult(inputResult);
        return Arrays.stream(inputResult.split(DELIMITER))
                .map(String::trim)
                .peek(LadderResults::isValidResult)
                .collect(Collectors.toList());
    }

    private static void isValidResult(String result) {
        if (Objects.isNull(result)|| "".equals(result)) {
            throw new IllegalArgumentException(ERROR_INVALID_PARAMETER);
        }
    }

    public LadderResultDTO resultByPoint(int index) {
        String result = Optional.ofNullable(ladderResults.get(index))
                .orElseThrow(ArrayIndexOutOfBoundsException::new);
        return new LadderResultDTO(result, index);
    }

    public String toString() {
        return ladderResults.stream()
                .map(this::pad)
                .collect(Collectors.joining(WHITE_SPACE));
    }

    private String pad(String input) {
        StringBuilder inputBuilder = new StringBuilder(input);
        IntStream.range(input.length(), MAXIMUM_NAME_LENGTH)
                .forEach(index -> inputBuilder.append(WHITE_SPACE));

        return inputBuilder.toString();
    }
}
