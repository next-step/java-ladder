package ladder.view.component.result;

import ladder.controller.LadderController;
import ladder.core.view.ViewImpl;
import ladder.core.view.output.Printer;
import ladder.domain.ladder.Ladder;
import ladder.domain.gamer.info.Gamer;
import ladder.domain.gamer.Gamers;
import ladder.core.message.Message;
import ladder.message.result.ResultMessage;
import ladder.view.component.View;
import ladder.view.model.LadderLines;

import java.util.stream.IntStream;

public class ResultView implements ViewImpl {
    private final static String RESULT_MESSAGE = "실행결과";
    private final static String EMPTY_STRING = "";
    private final static String ONE_SPACE_STRING = " ";
    private final static int MAX_NAME_SIZE = 5;
    
    private View view;
    
    public ResultView(LadderController controller, Printer printer) {
        view = new View.Builder(controller)
          .setPrinter(printer)
          .build();
    }
    
    @Override
    public void render(Message message) {
        if (!message.isResultStep()) {
            return;
        }
        ResultMessage resultMessage = (ResultMessage) message;
        view.print(RESULT_MESSAGE);
        view.print(getGamersExpression(resultMessage.getGamers()));
        printLadder(resultMessage.getLadder());
    }
    
    private String getGamersExpression(Gamers gamers) {
        return gamers.getStream()
          .map(Gamer::getName)
          .reduce((gamer1, gamer2) -> getGamerNameWithSpace(gamer1) + getGamerNameWithSpace(gamer2))
          .orElse(EMPTY_STRING);
    }
    
    private String getGamerNameWithSpace(String name) {
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
