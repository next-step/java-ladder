package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class LadderResult {
    public static final int EMPTY_SIZE = 0;
    private List<String> ladderResult;

    public LadderResult(String[] ladderResult) {
        this(Arrays.asList(ladderResult));
    }

    private LadderResult(List<String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public List<String> result(){
        return ladderResult;
    }

    public String get(int resultIndex) {
        if(valid(resultIndex)){
            throw new IllegalArgumentException("결과 값이 존재하지 않습니다.");
        }
        return ladderResult.get(resultIndex);
    }

    private boolean valid(int resultIndex) {
        return resultIndex < EMPTY_SIZE || resultIndex >= ladderResult.size();
    }

    public int size() {
        return ladderResult.size();
    }
}
