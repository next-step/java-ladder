package ladder.view.component.gamer;

import ladder.controller.LadderController;
import ladder.core.message.Response;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.View;
import ladder.message.gamer.GamerNamesDTO;

public class GamerView implements ViewImpl {
    private final static String ANSWER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    
    private View view;
    
    public GamerView(LadderController controller, Printer printer, Inputor inputor) {
        view = new View.Builder(controller)
          .setPrinter(printer)
          .setInputor(inputor)
          .build();
    }
    
    @Override
    public void render(Response response) {
        if (!response.isGamerStep()) {
            return;
        }
        view.print(ANSWER);
        view.pushDataToController(new GamerNamesDTO(view.inputString()));
    }
}
