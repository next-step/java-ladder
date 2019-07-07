package ladder.view.component.gamer;

import ladder.controller.LadderController;
import ladder.core.controller.Controller;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;
import ladder.view.constant.Step;

public class GamerView implements ViewImpl {
    private final static String ANSWER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    
    private Controller controller;
    private View view;
    
    public GamerView(LadderController controller, Printer printer, Inputor inputor) {
        this.controller = controller;
        view = new View.Builder(Step.GAMERS_STEP)
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
        Step.setNextStep(Step.REWARD_INPUT_STEP);
        controller.inputGamers(view.inputString());
    }
}
