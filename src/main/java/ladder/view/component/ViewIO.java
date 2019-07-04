package ladder.view.component;

import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;

public class ViewIO {
    private final Inputor inputor;
    private final Printer printer;
    
    public static class Builder {
        private Inputor inputor;
        private Printer printer;
        
        public Builder() {}
        
        public Builder setInputor(Inputor inputor) {
            this.inputor = inputor;
            return this;
        }
    
        public Builder setPrinter(Printer printer) {
            this.printer = printer;
            return this;
        }
        
        public ViewIO build() {
            return new ViewIO(inputor, printer);
        }
    }
    
    protected ViewIO(Inputor inputor, Printer printer) {
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
