package ladder.view.fake;

import ladder.view.input.BaseInputView;

public class FakeInputView extends BaseInputView {

    private final String input;

    public FakeInputView(String input) {
        this.input = input;
    }

    @Override
    public String read() {
        return input.trim();
    }

    @Override
    public String inputPlayerNames() {
        return this.input;
    }

    @Override
    public int inputLadderHeight() {
        return Integer.parseInt(this.input);
    }
}
