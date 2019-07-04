package ladder.view.component;

import ladder.core.controller.Controller;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;

public class View {
    private final Controller controller;
    private final Inputor inputor;
    private final Printer printer;
    
    public static class Builder {
        private Controller controller;
        private Inputor inputor;
        private Printer printer;
        
        public Builder(Controller controller) {
            this.controller = controller;
        }
        
        public Builder setInputor(Inputor inputor) {
            this.inputor = inputor;
            return this;
        }
    
        public Builder setPrinter(Printer printer) {
            this.printer = printer;
            return this;
        }
        
        public View build() {
            return new View(controller, inputor, printer);
        }
    }
    
    protected View(Controller controller, Inputor inputor, Printer printer) {
        this.controller = controller;
        this.inputor = inputor;
        this.printer = printer;
    }
    
    public void print(String content) {
        printer.print(content);
    }
    
    public String inputString() {
        return inputor.inputString();
    }
    
    public int inputNumber() {
        return inputor.inputNumber();
    }
}
