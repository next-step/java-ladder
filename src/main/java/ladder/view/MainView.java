package ladder.view;

import ladder.controller.LadderController;
import ladder.core.message.Message;
import ladder.core.view.ViewImpl;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.result.ResultView;
import ladder.view.component.gamer.GamerView;
import ladder.view.component.ladder.LadderView;
import ladder.view.component.result.InputGamerNameView;
import ladder.view.component.result.LadderResultView;
import ladder.view.component.reward.RewardInputView;
import ladder.view.input.ConsoleInputor;
import ladder.view.output.ConsolePrinter;

import java.util.Arrays;
import java.util.List;

public class MainView implements ViewImpl {
    private List<ViewImpl> views;
    
    public MainView(LadderController controller) {
        Printer printer = new ConsolePrinter();
        Inputor inputor = new ConsoleInputor();
        views = Arrays.asList(
            new GamerView(controller, printer, inputor),
            new RewardInputView(controller, printer, inputor),
            new LadderView(controller, printer, inputor),
            new LadderResultView(controller, printer),
            new InputGamerNameView(controller, printer, inputor),
            new ResultView(controller, printer)
        );
    }
    
    @Override
    public void render(Message message) {
        views.forEach(view -> view.render(message));
    }
}
