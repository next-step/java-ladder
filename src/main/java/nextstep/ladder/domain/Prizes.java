package nextstep.ladder.domain;

import nextstep.ladder.exception.PrizesSizeException;

import java.util.List;

public class Prizes {

    private final List<String> prizes;

    public Prizes(int numberOfParticipant, List<String> prizes) {
        validatePrizesSize(numberOfParticipant, prizes.size());
        this.prizes = prizes;
    }

    public static void validatePrizesSize(int numberOfParticipant, int prizesSize) {
        if (numberOfParticipant != prizesSize) {
            throw new PrizesSizeException(numberOfParticipant, prizesSize);
        }
    }

    public String getPrize(int index) {
        return prizes.get(index);
    }
}
