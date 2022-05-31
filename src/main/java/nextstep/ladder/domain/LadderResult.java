package nextstep.ladder.domain;

import java.util.Objects;

public class LadderResult {

    private static final String INVALID_LADDER_RESULT_VALUE = "사다리 결과는 비어있을 수 없습니다.";
    private final String value;

    public LadderResult(String value) {
        validate(value);
        this.value = value;
    }

    void validate(String value){
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(INVALID_LADDER_RESULT_VALUE);
        }
    }

    public static LadderResult of(String value) {
        return new LadderResult(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        LadderResult ladderResult = (LadderResult) obj;
        return Objects.equals(ladderResult.value, value);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(value);
    }
}
