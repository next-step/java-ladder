package ladder.entity.resultCase;

import java.util.Objects;

public class ResultCase {

    private String result;

    public ResultCase(String result){
        this.result = result.trim();
    }

    public String result() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultCase that = (ResultCase) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
