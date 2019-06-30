package ladder.core.view;

import ladder.controller.LadderController;
import ladder.core.message.Message;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;

public abstract class View {
    protected final LadderController controller;
    protected final Inputor inputor;
    protected final Printer printer;
    
    protected View(LadderController controller, Inputor inputor, Printer printer) {
        this.controller = controller;
        this.inputor = inputor;
        this.printer = printer;
    }
    
    public abstract void render(Message message);
}
