package nextstep.step2.domain;

import nextstep.step2.vo.Gifts;
import nextstep.step2.vo.Names;

public class GameInformation {

    private final Names names;
    private final Gifts gifts;

    private GameInformation(Names names, Gifts gifts) {
        this.names = names;
        this.gifts = gifts;
    }

    public static GameInformation of(Names names, Gifts gifts) {
        return new GameInformation(names, gifts);
    }
}
