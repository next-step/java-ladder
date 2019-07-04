package ladder.view.component.reward;

import ladder.core.controller.Controller;
import ladder.core.message.Response;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.message.request.reward.RewardRequest;
import ladder.view.component.ViewIO;

public class RewardInputView implements ViewImpl {
    private static final String ANSWER = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    
    private Controller controller;
    private ViewIO viewIO;
    
    public RewardInputView(Controller controller, Printer printer, Inputor inputor) {
        this.controller = controller;
        viewIO = new ViewIO.Builder()
          .setPrinter(printer)
          .setInputor(inputor)
          .build();
    }
    
    @Override
    public void render(Response response) {
        if (!response.isRewardInputStep()) {
            return;
        }
        viewIO.print(ANSWER);
        controller.inputReward(new RewardRequest(viewIO.inputString()));
    }
}
