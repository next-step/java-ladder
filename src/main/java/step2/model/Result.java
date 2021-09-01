package step2.model;

import static step2.model.LadderValidator.isBlank;

public class Result {
    private String result;

    public Result(String result) {
        isBlank(result);
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
