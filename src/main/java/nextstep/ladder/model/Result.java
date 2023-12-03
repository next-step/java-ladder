package nextstep.ladder.model;

import java.util.List;

public class Result {
    public static final List<String> BANNED = List.of("all");
    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        if (BANNED.contains(result)) {
            throw new IllegalArgumentException(result + ": 해당 문자는 금지되어 있습니다.(사유: 예약어)");
        }
    }
    public String result(){
        return this.result;
    }
}
