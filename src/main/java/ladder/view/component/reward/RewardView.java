package ladder.view.component.reward;

import ladder.core.controller.Controller;
import ladder.core.message.Response;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.message.reward.RewardDTO;
import ladder.view.component.View;

public class RewardView implements ViewImpl {
    private static final String ANSWER = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    
    private View view;
    
    public RewardView(Controller controller, Printer printer, Inputor inputor) {
        view = new View.Builder(controller)
          .setPrinter(printer)
          .setInputor(inputor)
          .build();
    }
    
    @Override
    public void render(Response response) {
        if (!response.isRewardStep()) {
            return;
        }
        view.print(ANSWER);
        view.pushDataToController(new RewardDTO(view.inputString()));
    }
}
