package ladder.view.component.gamer;

import ladder.controller.LadderController;
import ladder.core.controller.Controller;
import ladder.core.message.Response;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.ViewIO;
import ladder.message.request.gamer.GamerNames;

public class GamerView implements ViewImpl {
    private final static String ANSWER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    
    private Controller controller;
    private ViewIO viewIO;
    
    public GamerView(LadderController controller, Printer printer, Inputor inputor) {
        this.controller = controller;
        viewIO = new ViewIO.Builder()
            .setPrinter(printer)
            .setInputor(inputor)
            .build();
    }
    
    @Override
    public void render(Response response) {
        if (!response.isGamerStep()) {
            return;
        }
        viewIO.print(ANSWER);
        controller.inputGamers(new GamerNames(viewIO.inputString()));
    }
}
