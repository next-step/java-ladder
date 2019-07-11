package ladder.view.component.result;

import ladder.core.controller.ILadderController;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;

public class InputGamerNameView implements ViewImpl {
    private final static String ANSWER = "결과를 보고 싶은 사람은?";
    
    private ILadderController controller;
    private View view;
    
    public InputGamerNameView(ILadderController controller, Printer printer, Inputor inputor) {
        this.controller = controller;
        view = View.from(inputor, printer);
    }
    
    @Override
    public void render(Message message) {
        if (!message.isInputGamerNameStep()) {
            return;
        }
        view.print(ANSWER);
        controller.inputGamerName(view.inputString());
    }
}
