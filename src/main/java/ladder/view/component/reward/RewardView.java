package ladder.view.component.reward;

import ladder.core.controller.Controller;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;

public class RewardView implements ViewImpl {
    private View view;
    
    public RewardView(Controller controller, Printer printer, Inputor inputor) {
        view = new View.Builder(controller)
          .setPrinter(printer)
          .setInputor(inputor)
          .build();
    }
    
    @Override
    public void render(Message message) {
        if (!message.isRewardStep()) {
            return;
        }
    }
}
