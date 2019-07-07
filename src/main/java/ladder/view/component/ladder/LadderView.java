package ladder.view.component.ladder;

import ladder.core.controller.Controller;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;
import ladder.view.component.constant.Step;

public class LadderView implements ViewImpl {
    private static final String ANSWER = "최대 사다리 높이는 몇 개인가요?";
    
    private Controller controller;
    private View view;
    
    public LadderView(Controller controller, Printer printer, Inputor inputer) {
        this.controller = controller;
        view = new View.Builder(Step.LADDER_SIZE_STEP)
            .setPrinter(printer)
            .setInputor(inputer)
            .build();
    }
    
    @Override
    public void render(Message message) {
        if (!Step.isThisStep(view.getStep())) {
                 return;
        }
        Step.setNextStep(Step.RESULT_STEP);
        view.print(ANSWER);
        controller.inputLadderSize(view.inputNumber());
    }
}
