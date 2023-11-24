package nextstep.step4.responsibility.input;

import nextstep.step4.responsibility.domain.UserInputProvider;

public interface InputHandler {
    UserInputProvider inputUserNames();

    UserInputProvider inputUserResults();

    int inputLadderHeight();
}
