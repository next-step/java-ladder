package nextstep.refactoring.laddergame.engine.player;

import java.util.Collections;
import java.util.List;

public class PlayersDto {

    private final List<String> nameList;

    public PlayersDto(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> nameList() {
        return Collections.unmodifiableList(nameList);
    }
}
