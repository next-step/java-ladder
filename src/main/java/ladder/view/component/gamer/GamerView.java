package ladder.view.component.gamer;

import ladder.controller.LadderController;
import ladder.core.message.Message;
import ladder.core.view.View;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;

public class GamerView extends View {
    private final static String ANSWER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    
    public GamerView(LadderController controller, Inputor inputor, Printer printer) {
        super(controller, inputor, printer);
    }
    
    @Override
    public void render(Message message) {
        if (!message.isGamerStep()) {
            return;
        }
        printer.print(ANSWER);
        controller.inputGamers(inputor.inputString());
    }
}
