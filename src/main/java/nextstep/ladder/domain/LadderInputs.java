package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderInputs {

    private static final int FIRST_INDEX = 0;

    private final List<Input> inputs;

    public LadderInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    public static LadderInputs from(List<String> inputs) {
        List<Input> newInputs = inputs.stream()
                .map(input -> new Input(input.strip()))
                .collect(Collectors.toList());

        return new LadderInputs(newInputs);
    }

    public static LadderInputs from(List<String> inputs, LadderInputs participants) {
        if (inputs.size() != participants.countOfInputs()) {
            throw new IllegalArgumentException("참여할 사람 수와 결과 개수가 맞지 않습니다.");
        }

        return LadderInputs.from(inputs);
    }

    public boolean hasName(Input name) {
        return inputs.contains(name);
    }

    public int nameIndex(Input name) {
        return IntStream.range(FIRST_INDEX, inputs.size())
                .filter(i -> inputs.get(i).equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름이 없습니다."));
    }

    public String getInput(int index) {
        return inputs.get(index).getInput();
    }

    public int countOfInputs() {
        return inputs.size();
    }

    public List<Input> getInputs() {
        return inputs;
    }
}
