package ladder.view.component.ladder;

import ladder.core.controller.ILadderController;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;

public class LadderView implements ViewImpl {
    private static final String ANSWER = "최대 사다리 높이는 몇 개인가요?";
    
    private ILadderController controller;
    private View view;
    
    public LadderView(ILadderController controller, Printer printer, Inputor inputer) {
        this.controller = controller;
        view = View.from(inputer, printer);
    }
    
    @Override
    public void render(Message message) {
        if (!message.isLadderSizeStep()) {
                 return;
        }
        view.print(ANSWER);
        controller.inputLadderSize(view.inputNumber());
    }
}
