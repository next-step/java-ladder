package ladder.domain;

import java.util.Objects;

public class LadderResult {

    public String resultInfo;
    public Position position;

    public LadderResult(String result, int position) {
        this.resultInfo = result;
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(resultInfo, that.resultInfo) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultInfo, position);
    }
}
