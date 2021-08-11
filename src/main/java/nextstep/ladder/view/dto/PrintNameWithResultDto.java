package nextstep.ladder.view.dto;

import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Result;

public class PrintNameWithResultDto {

    private final Name name;
    private final Result result;

    public PrintNameWithResultDto(final Name name, final Result result) {
        this.name = name;
        this.result = result;
    }

    public Name getName() {
        return name;
    }

    public Result getResult() {
        return result;
    }
}
