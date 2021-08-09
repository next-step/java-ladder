package nextstep.ladder.view.dto;

import nextstep.ladder.domain.common.Result;

public class PrintResultDto {

    private final String value;

    public PrintResultDto(final Result result) {
        this.value = result.getValue();
    }

    public String getValue() {
        return value;
    }
}
