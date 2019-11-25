package nextstep.ladder.view;

import nextstep.InputTool;

public class BaseView {

    private final InputTool inputTool;

    public BaseView() {
        this.inputTool = new InputTool();
    }

    public String readLine() {
        return inputTool.readLine();
    }

    public int readInt() {
        return inputTool.readLineToInt();
    }

    public void showText(String text) {
        System.out.println(text);
    }
}
