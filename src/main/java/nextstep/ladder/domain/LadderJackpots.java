package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.exception.LengthNotEqualException;

public class LadderJackpots {
    private static final String REPLACE_STRING =  "\\[|\\]";
    private static final String TRANSFER_STRING = "";
    private static final String COMMA = ",";

    private List<String> jackpots;

    private LadderJackpots(List<String> jackpots) {
        this.jackpots = jackpots;
    }

    public static LadderJackpots of(String excutionResults, LadderNames ladderNames) {
        String[] results = excutionResults.split(COMMA);

        isLengthEqual(results.length, ladderNames.size());

        return new LadderJackpots(Arrays.stream(results)
                                        .collect(Collectors.toList()));
    }

    public String findJackpot(int index) {
        return jackpots.get(index);
    }

    public int result(int moveIndex, List<Lines> linesList) {
        Position position = Position.of(moveIndex);
        return position.run(linesList);
    }

    private static void isLengthEqual(int resultLength, int initLength) {
        if(resultLength != initLength) {
            throw new LengthNotEqualException("사람과 당첨 결과의 수는 같아야 합니다.");
        }
    }

    @Override
    public String toString() {
        return jackpots.toString().replaceAll(REPLACE_STRING, TRANSFER_STRING);
    }
}
