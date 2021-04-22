package step2.dto;

import step2.domain.Result;

public class ResponseResultDTO {
    private final Result result;

    public ResponseResultDTO(Result result) {
        this.result = result;
    }

    public String getResult() {
        return result.getResult();
    }
}
