package ladder.view.component.ladder;

import ladder.core.controller.Controller;
import ladder.core.message.Response;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;
import ladder.message.request.ladder.LadderSize;

public class LadderView implements ViewImpl {
    private static final String ANSWER = "최대 사다리 높이는 몇 개인가요?";
    
    private View view;
    
    public LadderView(Controller controller, Printer printer, Inputor inputer) {
        view = new View.Builder(controller)
          .setPrinter(printer)
          .setInputor(inputer)
          .build();
    }
    
    @Override
    public void render(Response response) {
        if (!response.isLadderSizeStep()) {
            return;
        }
        view.print(ANSWER);
        view.pushDataToController(new LadderSize(view.inputNumber()));
    }
}
