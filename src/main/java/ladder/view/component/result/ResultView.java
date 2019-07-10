package ladder.view.component.result;

import ladder.core.controller.Controller;
import ladder.core.controller.ILadderController;
import ladder.core.view.ViewImpl;
import ladder.core.view.output.Printer;
import ladder.domain.ladder.Ladder;
import ladder.core.message.Message;
import ladder.message.result.ResultMessage;
import ladder.view.component.View;
import ladder.view.component.constant.Step;
import ladder.view.model.LadderLines;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView implements ViewImpl {
    private final static String RESULT_MESSAGE = "실행결과";
    private final static String EMPTY_STRING = "";
    private final static String ONE_SPACE_STRING = " ";
    private final static int MAX_NAME_SIZE = 5;
    
    private ILadderController controller;
    private View view;
    
    public ResultView(ILadderController controller, Printer printer) {
        this.controller = controller;
        view = new View.Builder(Step.RESULT_STEP)
            .setPrinter(printer)
            .build();
    }
    
    @Override
    public void render(Message message) {
        if (!message.isResultStep()) {
            return;
        }
        ResultMessage resultResponseMessage = (ResultMessage) message;
        view.print(RESULT_MESSAGE);
        view.print(getItemExpression(resultResponseMessage.getGamerNames()));
        printLadder(resultResponseMessage.getLadder());
        view.print(getItemExpression(resultResponseMessage.getRewardNames()));
        Step.setNextStep(Step.GAMER_NAME_INPUT_STEP);
        controller.callAfterResult();
    }
    
    private String getItemExpression(List<String> items) {
        return items.stream()
            .reduce((item1, item2) -> getNamesWithSpace(item1) + getNamesWithSpace(item2))
            .orElse(EMPTY_STRING);
    }
    
    private String getNamesWithSpace(String name) {
        return name + IntStream.range(name.length(), MAX_NAME_SIZE)
            .mapToObj(i -> ONE_SPACE_STRING)
            .reduce((str1, str2) -> str1 + str2)
            .orElse(EMPTY_STRING);
    }
    
    private void printLadder(Ladder ladder) {
        LadderLines.newLadderLines(ladder).stream()
            .forEach(view::print);
    }
}
