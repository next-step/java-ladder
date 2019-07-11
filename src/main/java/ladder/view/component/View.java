package ladder.view.component;

import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;

public class View {
    private Inputor inputor;
    private Printer printer;
    
    private View(Printer printer) {
        this.printer = printer;
    }
    
    private View(Inputor inputor, Printer printer) {
        this.inputor = inputor;
        this.printer = printer;
    }
    
    public static View from(Printer printer) {
        return new View(printer);
    }
    
    public static View from(Inputor inputor, Printer printer) {
        return new View(inputor, printer);
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
