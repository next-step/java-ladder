package ladder.view.component.result;

import ladder.core.controller.Controller;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;
import ladder.view.component.constant.Step;

public class InputGamerNameView implements ViewImpl {
    private final static String ANSWER = "결과를 보고 싶은 사람은?";
    
    private Controller controller;
    private View view;
    
    public InputGamerNameView(Controller controller, Printer printer, Inputor inputor) {
        this.controller = controller;
        view = new View.Builder(Step.GAMER_NAME_INPUT_STEP)
          .setPrinter(printer)
          .setInputor(inputor)
          .build();
    }
    
    @Override
    public void render(Message message) {
        if (!Step.isThisStep(view.getStep())) {
            return;
        }
        view.print(ANSWER);
        Step.setNextStep(Step.REWARD_STEP);
        controller.inputGamerName(view.inputString());
    }
}
