package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderInputs {

    private static final int FIRST_INDEX = 0;

    private final List<LadderInput> ladderInputs;

    private LadderInputs(List<LadderInput> ladderInputs) {
        this.ladderInputs = ladderInputs;
    }

    public static LadderInputs from(List<String> inputs) {
        List<LadderInput> newLadderInputs = inputs.stream()
                .map(input -> new LadderInput(input.strip()))
                .collect(Collectors.toList());

        return new LadderInputs(newLadderInputs);
    }

    public static LadderInputs from(List<String> ladderInputs, LadderInputs participants) {
        if (ladderInputs.size() != participants.countOfInputs()) {
            throw new IllegalArgumentException("참여할 사람 수와 결과 개수가 맞지 않습니다.");
        }

        return LadderInputs.from(ladderInputs);
    }

    public boolean hasName(LadderInput name) {
        return ladderInputs.contains(name);
    }

    public int nameIndex(LadderInput name) {
        return IntStream.range(FIRST_INDEX, ladderInputs.size())
                .filter(i -> ladderInputs.get(i).equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름이 없습니다."));
    }

    public String getInput(int index) {
        return ladderInputs.get(index).getLadderInput();
    }

    public int countOfInputs() {
        return ladderInputs.size();
    }

    public List<LadderInput> getInputs() {
        return ladderInputs;
    }
}
