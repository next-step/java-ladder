package nextstep.ladder.domain;

public class Result {
    private String result;

    public Result(String result) {
        if (result == null || result.isBlank()){
            throw new IllegalArgumentException("결과는 빈 값일 수 없습니다");
        }
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
