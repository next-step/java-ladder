package ladder.view.component.result;

import ladder.core.controller.Controller;
import ladder.core.message.Response;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;

public class InputGamerNameView implements ViewImpl {
    public final static String ANSWER = "결과를 보고 싶은 사람은?";
    
    private View view;
    
    public InputGamerNameView(Controller controller, Printer printer, Inputor inputor) {
        view = new View.Builder(controller)
          .setPrinter(printer)
          .setInputor(inputor)
          .build();
    }
    
    @Override
    public void render(Response response) {
        view.print(ANSWER);
        view.pushDataToController(view.inputString());
    }
}
