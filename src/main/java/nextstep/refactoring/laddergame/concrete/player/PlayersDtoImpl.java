package nextstep.refactoring.laddergame.concrete.player;

import nextstep.refactoring.laddergame.engine.player.PlayersDto;

import java.util.Collections;
import java.util.List;

public class PlayersDtoImpl implements PlayersDto {

    private final List<String> nameList;

    public PlayersDtoImpl(List<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public List<String> nameList() {
        return Collections.unmodifiableList(nameList);
    }
}
