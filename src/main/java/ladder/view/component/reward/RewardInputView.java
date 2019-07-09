package ladder.view.component.reward;

import ladder.core.controller.ILadderController;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;
import ladder.view.component.constant.Step;

public class RewardInputView implements ViewImpl {
    private static final String ANSWER = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    
    private ILadderController controller;
    private View view;
    
    public RewardInputView(ILadderController controller, Printer printer, Inputor inputor) {
        this.controller = controller;
        view = new View.Builder(Step.REWARD_INPUT_STEP)
          .setPrinter(printer)
          .setInputor(inputor)
          .build();
    }
    
    @Override
    public void render(Message message) {
        if (!message.isInputRewardStep()) {
            return;
        }
        view.print(ANSWER);
        Step.setNextStep(Step.LADDER_SIZE_STEP);
        controller.inputReward(view.inputString());
    }
}
