package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.exception.LadderExceptionMessage.CHECK_PRIZES_LENGTH;
import static nextstep.ladder.utils.StringUtil.splitWithComma;

public class Prizes {
    private final List<Prize> prizeList;

    public Prizes(int countOfPlayer, String... prizes) {
        this(new CountOfPlayer(countOfPlayer), convertToPrizes(prizes));
    }

    public Prizes(CountOfPlayer countOfPlayer, String... prizes) {
        this(countOfPlayer, convertToPrizes(prizes));
    }

    private static List<Prize> convertToPrizes(String[] prizes) {
        return Arrays.stream(prizes)
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public Prizes(CountOfPlayer countOfPlayer, String prizes) {
        this(countOfPlayer, convertToPrizes(splitWithComma(prizes)));
    }

    private static List<Prize> convertToPrizes(List<String> prizes) {
        return prizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public Prizes(CountOfPlayer countOfPlayer, List<Prize> prizeList) {
        validateLength(countOfPlayer.number(), prizeList.size());
        this.prizeList = prizeList;
    }

    private void validateLength(int countOfPlayer, int countOfPrize) {
        if (countOfPlayer != countOfPrize) {
            throw new LadderException(CHECK_PRIZES_LENGTH);
        }
    }

    public List<Prize> allPrizes() {
        return prizeList;
    }

    public List<String> names() {
        return prizeList.stream()
                .map(Prize::value)
                .collect(Collectors.toList());
    }
}
