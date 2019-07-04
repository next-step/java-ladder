package ladder.view.component.result;

import ladder.core.controller.Controller;
import ladder.core.view.ViewImpl;
import ladder.core.view.output.Printer;
import ladder.domain.ladder.Ladder;
import ladder.core.message.Response;
import ladder.message.response.result.Result;
import ladder.view.component.View;
import ladder.view.model.LadderLines;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView implements ViewImpl {
    private final static String RESULT_MESSAGE = "실행결과";
    private final static String EMPTY_STRING = "";
    private final static String ONE_SPACE_STRING = " ";
    private final static int MAX_NAME_SIZE = 5;
    
    private View view;
    
    public ResultView(Controller controller, Printer printer) {
        view = new View.Builder(controller)
            .setPrinter(printer)
            .build();
    }
    
    @Override
    public void render(Response response) {
        if (!response.isResultStep()) {
            return;
        }
        Result resultMessage = (Result) response;
        view.print(RESULT_MESSAGE);
        view.print(getItemExpression(resultMessage.getGamerNames()));
        printLadder(resultMessage.getLadder());
        view.print(getItemExpression(resultMessage.getRewardNames()));
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
