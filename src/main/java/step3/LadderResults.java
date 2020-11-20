package step3;

import step3.domain.ladder.dto.LadderResultDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class LadderResults {
    public static final String ERROR_INVALID_PARAMETER = "유효하지 않은 결과입니다.";
    private final List<String> ladderResults;

    private LadderResults(List<String> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults of(String inputResult) {
        List<String> list = stringToList(inputResult);
        return new LadderResults(list);
    }

    private static List<String> stringToList(String inputResult) {
        isValidResult(inputResult);
        return Arrays.stream(inputResult.split(","))
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
}
