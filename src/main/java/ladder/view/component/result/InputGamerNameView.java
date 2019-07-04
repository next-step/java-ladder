package ladder.view.component.result;

import ladder.core.controller.Controller;
import ladder.core.message.Response;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.message.request.result.GamerName;
import ladder.view.component.View;

public class InputGamerNameView implements ViewImpl {
    private final static String ANSWER = "결과를 보고 싶은 사람은?";
    
    private Controller controller;
    private View view;
    
    public InputGamerNameView(Controller controller, Printer printer, Inputor inputor) {
        this.controller = controller;
        view = new View.Builder(controller)
          .setPrinter(printer)
          .setInputor(inputor)
          .build();
    }
    
    @Override
    public void render(Response response) {
        if (!response.isGamerNameInputStep()) {
            return;
        }
        view.print(ANSWER);
        controller.inputGamerName(new GamerName(view.inputString()));
    }
}
