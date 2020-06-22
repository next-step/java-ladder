package ladder.domain;

import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prizes {

    public static final String LADDER_RESULTS_INVALID_EXCEPTION = "결과값은 참여자 숫자와 다를 수 없습니다.";

    private static final String LADDER_RESULTS_NULL_EXCEPTION = "결과값은 빈값으로 입력할 수 없습니다.";

    private final List<String> prizes;

    private Prizes(List<String> prizes, int countOfperson) {
        validatePrizesCount(prizes, countOfperson);
        this.prizes = prizes;
    }

    private void validatePrizesCount(List<String> prizes, int countOfperson) {
        if (prizes.size() != countOfperson){
            throw new IllegalArgumentException(LADDER_RESULTS_INVALID_EXCEPTION);
        }
    }

    public static Prizes of(String prizes, int countOfperson){
        validatePrizesString(prizes);
        return new Prizes(convertToList(prizes), countOfperson);
    }

    private static void validatePrizesString(String prizes) {
        if (Objects.isNull(prizes) || prizes.isEmpty()){
            throw new IllegalArgumentException(LADDER_RESULTS_NULL_EXCEPTION);
        }
    }

    private static List<String> convertToList(String ladderResults) {
        return Arrays.stream(StringUtil.split(ladderResults))
                     .collect(Collectors.toList());
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
