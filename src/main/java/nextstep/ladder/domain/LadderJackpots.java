package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.exception.LengthNotEqualException;

public class LadderJackpots {
    private static final String REPLACE_STRING =  "\\[|\\]";
    private static final String TRANSFER_STRING = "";
    private static final String COMMA = ",";
    List<LadderJackpot> jackpots;

    private LadderJackpots(List<LadderJackpot> jackpots) {
        this.jackpots = jackpots;
    }

    public static LadderJackpots of(String excutionResults, String initPerson) {
        String[] results = excutionResults.split(COMMA);

        if(results.length != initPerson.split(COMMA).length) {
            throw new LengthNotEqualException();
        }

        return new LadderJackpots(Arrays.stream(results)
                                        .map(LadderJackpot::of)
                                        .collect(Collectors.toList()));
    }

    public String findJackpot(int index) {
        return jackpots.get(index).findJackpot();
    }

    public int result(int moveIndex, List<Lines> linesList) {
        Position position = Position.of(moveIndex);
        return position.run(linesList);
    }

    @Override
    public String toString() {
        return jackpots.toString().replaceAll(REPLACE_STRING, TRANSFER_STRING);
    }
}
