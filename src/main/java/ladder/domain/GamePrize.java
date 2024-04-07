package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamePrize {
    private final static int MAX_PRIZE_LENGTH = 5;
    private final static int MIN_PRIZE_LENGTH = 1;
    private final static String BLANK = " ";

    private final List<String> prize;

    public GamePrize(List<String> prize) {
        this.prize = prize;
    }

    public static GamePrize generateGamePrize(String[] input) {
        final List<String> prize = Stream.of(input)
                .map(GamePrize::checkValidPrize)
                .collect(Collectors.toList());

        return new GamePrize(prize);
    }

    private static String checkValidPrize(String prize) {
        if (prize.contains(BLANK)) {
            throw new IllegalArgumentException("결과값은 공백을 포함할 수 없습니다.");
        }

        if (!isValidLength(prize)) {
            throw new IllegalArgumentException("결과값은 1자 이상 5자 이하여야 합니다.");
        }

        return prize;
    }

    private static boolean isValidLength(String prize) {
        return prize.length() >= MIN_PRIZE_LENGTH && prize.length() <= MAX_PRIZE_LENGTH;
    }

    public List<String> getPrize() {
        return prize;
    }

    public String prizeOf(int index) {
        return prize.get(index);
    }
}
