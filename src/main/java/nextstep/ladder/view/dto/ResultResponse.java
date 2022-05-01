package nextstep.ladder.view.dto;

import nextstep.ladder.model.Result;

public final class ResultResponse {

    private final String value;

    private ResultResponse(String value) {
        this.value = value;
    }

    public static ResultResponse from(Result result) {
        return new ResultResponse(result.value());
    }

    public String getValue() {
        return value;
    }
}
