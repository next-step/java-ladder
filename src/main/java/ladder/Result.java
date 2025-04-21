package ladder;

public class Result {
    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    public void validate(String result) {
        if(result.isBlank()) {
            throw new IllegalArgumentException("결과는 빈 값일수없습니다.");
        }
        if( result.length() > 5) {
            throw new IllegalArgumentException("결과는 5글자 이상일 수 없습니다.");
        }
    }
}
