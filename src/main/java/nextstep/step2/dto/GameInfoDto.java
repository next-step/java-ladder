package nextstep.step2.dto;

import nextstep.step2.vo.Gifts;
import nextstep.step2.vo.Names;

public class GameInfoDto {

    private final Names names;
    private final Gifts gifts;

    private GameInfoDto(Names names, Gifts gifts) {
        this.names = names;
        this.gifts = gifts;
    }

    public static GameInfoDto of(String namesString, String giftsString) {
        return new GameInfoDto(Names.of(namesString), Gifts.of(giftsString));
    }

    public Names getNames() {
        return names;
    }

    public Gifts getGifts() {
        return gifts;
    }
}
