package ladder.view;

import ladder.controller.LadderController;
import ladder.core.message.Message;
import ladder.core.view.View;
import ladder.view.component.gamer.GamerView;
import ladder.view.input.ConsoleInputor;
import ladder.view.output.ConsolePrinter;
import ladder.view.component.ladder.LadderView;
import ladder.view.component.result.ResultView;

import java.util.Arrays;
import java.util.List;

public class MainView extends View {
    private List<View> views;
    
    public MainView(LadderController controller) {
        super(controller, new ConsoleInputor(), new ConsolePrinter());
        views = Arrays.asList(
          new LadderView(controller, inputor, printer),
          new GamerView(controller, inputor, printer),
          new ResultView(controller, inputor, printer)
        );
    }
    
    @Override
    public void render(Message message) {
        views.forEach(view -> view.render(message));
    }
}
