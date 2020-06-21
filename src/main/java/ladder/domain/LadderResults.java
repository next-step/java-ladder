package ladder.domain;

import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResults {

    public static final String LADDER_RESULTS_INVALID_EXCEPTION = "결과값은 참여자 숫자와 다를 수 없습니다.";

    private static final String LADDER_RESULTS_NULL_EXCEPTION = "결과값은 빈값으로 입력할 수 없습니다.";

    private final List<String> ladderResults;

    private LadderResults(List<String> ladderResults, int countOfperson) {
        validatePrizesCount(ladderResults, countOfperson);
        this.ladderResults = ladderResults;
    }

    private void validatePrizesCount(List<String> ladderResults, int countOfperson) {
        if (ladderResults.size() != countOfperson){
            throw new IllegalArgumentException(LADDER_RESULTS_INVALID_EXCEPTION);
        }
    }

    public static LadderResults of(String ladderResults, int countOfperson){
        validatePrizesString(ladderResults);
        return new LadderResults(convertToList(ladderResults), countOfperson);
    }

    private static void validatePrizesString(String ladderResults) {
        if (Objects.isNull(ladderResults) || ladderResults.isEmpty()){
            throw new IllegalArgumentException(LADDER_RESULTS_NULL_EXCEPTION);
        }
    }

    private static List<String> convertToList(String ladderResults) {
        return Arrays.stream(StringUtil.split(ladderResults))
                     .collect(Collectors.toList());
    }

    public List<String> getLadderResults() {
        return ladderResults;
    }
}
