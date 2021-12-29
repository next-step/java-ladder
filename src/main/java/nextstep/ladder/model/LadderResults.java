package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class LadderResults {

    private final List<LadderResult> ladderResults;

    private LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = new ArrayList<>(ladderResults);
    }

    public static LadderResults from(List<String> ladderResults) {
        validate(ladderResults);
        return new LadderResults(ladderResults(ladderResults));
    }

    private static void validate(List<String> ladderResults) {
        if (Objects.isNull(ladderResults)) {
            throw new IllegalArgumentException("전달된 사다리 결과 그룹이 null 입니다.");
        }
        if (ladderResults.isEmpty()) {
            throw new IllegalArgumentException("전달된 사다리 결과 그룹이 비어있습니다.");
        }
    }

    private static List<LadderResult> ladderResults(List<String> ladderResults) {
        return ladderResults.stream()
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

    public List<LadderResult> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }

    public LadderResult get(int index) {
        if (isOutboundIndex(index)) {
            throw new IllegalArgumentException(String.format("입력된 index(%d)는 결과의 최대 index(%d)를 넘어갈 수 없습니다.", index, maxIndex()));
        }
        return ladderResults.get(index);
    }

    private int maxIndex() {
        return size() - 1;
    }

    private boolean isOutboundIndex(int index) {
        return size() <= index;
    }

    public int size() {
        return ladderResults.size();
    }
}
