package nextstep.ladder.view.dto;

import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Result;

public class PrintPlayerDto {

    private final Name name;
    private final Result result;

    public PrintPlayerDto(final Player player) {
        this.name = player.getName();
        this.result = player.getResult();
    }

    public Name getName() {
        return name;
    }

    public Result getResult() {
        return result;
    }
}
