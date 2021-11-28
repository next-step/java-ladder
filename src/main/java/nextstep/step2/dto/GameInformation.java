package nextstep.step2.dto;

import nextstep.step2.vo.Names;

public class GameInformation {

    private final Names names;

    private GameInformation(Names names) {
        this.names = names;
    }

    public static GameInformation createWithString(String namesString) {
        return new GameInformation(Names.createWithString(namesString));
    }

    public Names getNames() {
        return names;
    }
}
