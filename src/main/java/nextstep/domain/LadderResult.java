package nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final List<String> result;
    private final List<Integer> resultIndex = new ArrayList<>();

    public LadderResult(List<String> result) {
        this.result = result;
    }

    public void addResultIndex(int resultIndex) {
        this.resultIndex.add(resultIndex);
    }

    public List<String> getResult() {
        return result;
    }

    public int getResultSize() {
        return this.result.size();
    }

    public List<Integer> getResultIndex() {
        return resultIndex;
    }

    public String find(int userIndex) {
        if (userIndex < 0) {
            throw new IllegalArgumentException("유저를 찾을 수 없습니다.");
        }
        return this.result.get(this.resultIndex.get(userIndex));
    }

}
