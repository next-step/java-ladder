package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderInputs {

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

    public int countOfInputs() {
        return inputs.size();
    }

    public List<Input> getInputs() {
        return inputs;
    }
}
