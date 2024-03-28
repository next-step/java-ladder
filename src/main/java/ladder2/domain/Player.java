package ladder2.domain;

import java.util.Optional;

public class Player {

    private static final String NO_PRIZE_EXCEPTION_MESSAGE = "아직 당첨 결과를 전달받지 못했습니다";
    
    private final int index;
    private final String name;
    private Optional<Prize> prize;

    public Player(int index, String name) {
        this.index = index;
        this.name = name;
        this.prize = Optional.empty();
    }

    public void receivePrize(Prize prize) {
        this.prize = Optional.ofNullable(prize);
    }

    public String name() {
        return name;
    }

    public Prize prize() {
        return prize.orElseThrow(() -> new IllegalStateException(NO_PRIZE_EXCEPTION_MESSAGE));
    }
}
