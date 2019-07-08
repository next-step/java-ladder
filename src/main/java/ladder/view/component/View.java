package ladder.view.component;

import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;
import ladder.view.component.constant.Step;

public class View {
    private final Inputor inputor;
    private final Printer printer;
    private final Step step;
    
    public static class Builder {
        private Inputor inputor;
        private Printer printer;
        private Step step;
        
        public Builder(Step step) {
            this.step = step;
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
            return new View(step, inputor, printer);
        }
    }
    
    private View(Step step, Inputor inputor, Printer printer) {
        this.step = step;
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
    
    public Step getStep() {
        return step;
    }
}
