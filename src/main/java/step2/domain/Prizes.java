package step2.domain;

import step2.exception.IllegalPlayerSizeException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Prizes {
    private final List<String> prizes;

    public Prizes(List<String> prizes, int playerSize) {
        validateSize(prizes, playerSize);

        this.prizes = prizes;
    }

    private void validateSize(List<String> prizes, int playerSize) {
        if (prizes.size() > playerSize) {
            throw new IllegalPlayerSizeException("잘못된 playerSize입니다.");
        }
    }

    public static Prizes of(String prize, int playerSize) {
        List<String> prizes = Arrays.stream(prize.split(Players.SPLIT_COMMA))
                .collect(toList());

        return new Prizes(prizes, playerSize);
    }

    public List<String> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
