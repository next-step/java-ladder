package nextstep.step2.domain;

import nextstep.step2.vo.Gifts;
import nextstep.step2.vo.Names;

public class GameInfo {

    private final Names names;
    private final Gifts gifts;

    private GameInfo(Names names, Gifts gifts) {
        this.names = names;
        this.gifts = gifts;
    }

    public static GameInfo of(Names names, Gifts gifts) {
        return new GameInfo(names, gifts);
    }
}
