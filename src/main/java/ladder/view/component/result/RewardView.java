package ladder.view.component.result;

import ladder.core.controller.Controller;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.output.Printer;
import ladder.message.result.RewardMessage;
import ladder.view.component.View;
import ladder.view.constant.Step;

public class RewardView implements ViewImpl {
    private Controller controller;
    private View view;
    
    public RewardView(Controller controller, Printer printer) {
        this.controller = controller;
        view = new View.Builder(Step.REWARD_STEP)
            .setPrinter(printer)
            .build();
    }
    
    @Override
    public void render(Message message) {
        if (!Step.isThisStep(view.getStep())) {
            return;
        }
        RewardMessage rewardResponse = (RewardMessage) message;
        Step.setNextStep(Step.GAMER_NAME_INPUT_STEP);
        view.print(rewardResponse.getReward());
    }
}
