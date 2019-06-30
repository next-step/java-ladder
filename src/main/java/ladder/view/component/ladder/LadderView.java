package ladder.view.component.ladder;

import ladder.controller.LadderController;
import ladder.core.message.Message;
import ladder.core.view.View;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;

public class LadderView extends View {
    private static final String ANSWER = "최대 사다리 높이는 몇 개인가요?";
    
    public LadderView(LadderController controller, Inputor inputor, Printer printer) {
        super(controller, inputor, printer);
    }
    
    @Override
    public void render(Message message) {
        if (!message.isLadderSizeStep()) {
            return;
        }
        printer.print(ANSWER);
        controller.inputLadderSize(inputor.inputNumber());
    }
}
