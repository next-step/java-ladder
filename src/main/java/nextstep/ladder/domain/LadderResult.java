package nextstep.ladder.domain;

import java.util.Objects;

public class LadderResult {
    private final String value;

    public LadderResult(String value) {
        this.value = value;
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
