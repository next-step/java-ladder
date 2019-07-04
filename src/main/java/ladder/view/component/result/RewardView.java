package ladder.view.component.result;

import ladder.core.controller.Controller;
import ladder.core.message.Response;
import ladder.core.view.ViewImpl;
import ladder.core.view.output.Printer;
import ladder.message.response.result.RewardResponse;
import ladder.view.component.ViewIO;

public class RewardView implements ViewImpl {
    private Controller controller;
    private ViewIO viewIO;
    
    public RewardView(Controller controller, Printer printer) {
        this.controller = controller;
        viewIO = new ViewIO.Builder()
            .setPrinter(printer)
            .build();
    }
    
    @Override
    public void render(Response response) {
        if (!response.isRewardStep()) {
            return;
        }
        RewardResponse rewardResponse = (RewardResponse) response;
        viewIO.print(rewardResponse.getReward());
    }
}
