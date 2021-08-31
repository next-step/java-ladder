package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    public static final int EMPTY_SIZE = 0;
    private List<String> ladderResult;

    public LadderResult(String[] ladderResult) {
        this(Arrays.stream(ladderResult).collect(Collectors.toList()));
    }

    private LadderResult(List<String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public List<String> result(){
        return ladderResult;
    }

    public String get(int resultIndex) {
        if(resultIndex < EMPTY_SIZE || resultIndex >= ladderResult.size()){
            throw new IllegalArgumentException("결과 값이 존재하지 않습니다.");
        }
        return ladderResult.get(resultIndex);
    }
}
