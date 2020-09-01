package ladder.controller;

import ladder.ui.Input;
import ladder.ui.Output;

public class LadderControllerBuilder {

    private Input input;
    private Output output;

    public LadderControllerBuilder input(Input input) {
        this.input = input;
        return this;
    }

    public LadderControllerBuilder output(Output output) {
        this.output = output;
        return this;
    }

    public LadderController build() {
        return new LadderController(this);
    }

    public Input getInput() {
        return input;
    }

    public Output getOutput() {
        return output;
    }
}
