package ladder.view.component.result;

import ladder.core.controller.ILadderController;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.output.Printer;
import ladder.message.result.RewardMessage;
import ladder.view.component.View;
import ladder.view.component.constant.Step;

public class RewardView implements ViewImpl {
    private ILadderController controller;
    private View view;
    
    public RewardView(ILadderController controller, Printer printer) {
        this.controller = controller;
        view = new View.Builder(Step.REWARD_STEP)
            .setPrinter(printer)
            .build();
    }
    
    @Override
    public void render(Message message) {
        if (!message.isRewardStep()) {
            return;
        }
        RewardMessage rewardResponse = (RewardMessage) message;
        Step.setNextStep(Step.GAMER_NAME_INPUT_STEP);
        view.print(rewardResponse.getReward());
        controller.callAfterResult();
    }
}
