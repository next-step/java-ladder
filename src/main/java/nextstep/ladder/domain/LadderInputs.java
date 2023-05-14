package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderInputs {

    private static final int FIRST_INDEX = 0;

    private final List<LadderInput> ladderInputs;

    public LadderInputs(List<LadderInput> ladderInputs) {
        this.ladderInputs = ladderInputs;
    }

    public static LadderInputs from(List<String> ladderInputs) {
        List<LadderInput> newLadderInputs = ladderInputs.stream()
                .map(input -> new LadderInput(input.strip()))
                .collect(Collectors.toList());

        return new LadderInputs(newLadderInputs);
    }

    public static LadderInputs from(List<String> ladderInputs, LadderInputs participants) {
        if (ladderInputs.size() != participants.countOfInputs()) {
            throw new IllegalArgumentException("참가자 수와 결과 개수가 일치하지 않습니다.");
        }
        return LadderInputs.from(ladderInputs);
    }

    public int countOfInputs() {
        return ladderInputs.size();
    }

    public boolean hasName(LadderInput ladderInput) {
        return ladderInputs.contains(ladderInput);
    }

    public int nameIndex(LadderInput ladderInput) {
        return IntStream.range(FIRST_INDEX, ladderInputs.size())
                .filter(i -> ladderInputs.get(i).equals(ladderInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름이 없습니다."));
    }

    public List<LadderInput> getInputs() {
        return ladderInputs;
    }

    public String getInput(int index) {
        return ladderInputs.get(index).getLadderInput();
    }
}
