package nextstep.ladder.validator;

import nextstep.ladder.domain.LadderGamePrize;
import nextstep.ladder.exception.LadderGamePrizeFormatException;

import java.util.List;

public class LadderGamePrizeValidator {

    public static void validatePrizes(List<String> prizes) throws LadderGamePrizeFormatException {
        for (String prize : prizes) {
            validatePrize(prize);
        }
    }

    private static void validatePrize(String prize) throws LadderGamePrizeFormatException {
        if (notMiss(prize) && notNumeric(prize)) {
            throw new LadderGamePrizeFormatException(prize);
        }
    }

    private static boolean notMiss(String prize) {
        return !LadderGamePrize.MISS.equals(prize);
    }

    private static boolean notNumeric(String prize) {
        return !prize.matches(LadderGamePrize.PRIZE_FORMAT_REGEX);
    }

}
