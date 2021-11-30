package nextstep.step2.dto;

import nextstep.step2.vo.Names;

public class GameInformation {

    private final Names names;

    private GameInformation(Names names) {
        this.names = names;
    }

    public static GameInformation of(String namesString) {
        return new GameInformation(Names.of(namesString));
    }

    public Names getNames() {
        return names;
    }
}
