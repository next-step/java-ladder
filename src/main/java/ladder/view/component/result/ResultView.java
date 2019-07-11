package ladder.view.component.result;

import ladder.core.controller.ILadderController;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.output.Printer;
import ladder.message.ResultMessage;
import ladder.view.component.View;
import ladder.view.model.AllResult;

public class ResultView implements ViewImpl {
    private ILadderController controller;
    private View view;
    
    public ResultView(ILadderController controller, Printer printer) {
        this.controller = controller;
        view = View.from(printer);
    }
    
    @Override
    public void render(Message message) {
        if (!message.isRewardStep()) {
            return;
        }
        ResultMessage rewardResponse = (ResultMessage) message;
        view.print(rewardResponse.getReward());
        view.print(AllResult.of(rewardResponse.getResults()).getAllResultString());
        controller.callAfterLadderResult();
    }
}
