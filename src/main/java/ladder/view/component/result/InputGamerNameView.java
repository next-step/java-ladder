package ladder.view.component.result;

import ladder.core.controller.Controller;
import ladder.core.message.Response;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.message.request.result.GamerName;
import ladder.view.component.ViewIO;

public class InputGamerNameView implements ViewImpl {
    private final static String ANSWER = "결과를 보고 싶은 사람은?";
    
    private Controller controller;
    private ViewIO viewIO;
    
    public InputGamerNameView(Controller controller, Printer printer, Inputor inputor) {
        this.controller = controller;
        viewIO = new ViewIO.Builder()
          .setPrinter(printer)
          .setInputor(inputor)
          .build();
    }
    
    @Override
    public void render(Response response) {
        if (!response.isGamerNameInputStep()) {
            return;
        }
        viewIO.print(ANSWER);
        controller.inputGamerName(new GamerName(viewIO.inputString()));
    }
}
