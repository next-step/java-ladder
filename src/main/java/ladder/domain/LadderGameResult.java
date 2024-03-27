package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LadderGameResult {

    private final Map<Participant, String> judgeResult;

    private LadderGameResult(Map<Participant, String> judgeResult) {
        this.judgeResult = judgeResult;
    }

    public static LadderGameResult from(Map<Participant, String> judgeResult) {
        return new LadderGameResult(Collections.unmodifiableMap(judgeResult));
    }

    public String get(Participant participant) {
        return judgeResult.get(participant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderGameResult that = (LadderGameResult) o;
        return Objects.equals(judgeResult, that.judgeResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(judgeResult);
    }

    @Override
    public String toString() {
        return "LadderGameResult{" +
            "judgeResult=" + judgeResult +
            '}';
    }
}
