package step2.model;

import static step2.model.LadderValidator.isBlank;

public class Result {
    private final String result;

    public Result(String result) {
        isBlank(result);
        this.result = result.trim();
    }

    public String getResult() {
        return result;
    }
}
