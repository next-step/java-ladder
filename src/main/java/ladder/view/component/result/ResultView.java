package ladder.view.component.result;

import ladder.controller.LadderController;
import ladder.domain.ladder.Ladder;
import ladder.domain.gamer.info.Gamer;
import ladder.domain.gamer.Gamers;
import ladder.core.message.Message;
import ladder.domain.ladder.unit.Cell;
import ladder.message.result.ResultMessage;
import ladder.core.view.View;
import ladder.core.view.input.Inputor;
import ladder.core.view.output.Printer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView extends View {
    private final static String RESULT_MESSAGE = "실행결과";
    private final static String EMPTY_STRING = "";
    private final static String ONE_SPACE_STRING = " ";
    private final static String LADDER_HORIZON_LINE = "----";
    private final static String LADDER_HORIZON_EMPTY = "    ";
    private final static String LADDER_VERTICAL = "|";
    private final static int MAX_NAME_SIZE = 5;
    private final static int START_COUNT = 0;
    
    public ResultView(LadderController controller, Inputor inputor, Printer printer) {
        super(controller, inputor, printer);
    }
    
    @Override
    public void render(Message message) {
        if (!message.isResultStep()) {
            return;
        }
        ResultMessage resultMessage = (ResultMessage) message;
        printer.print(RESULT_MESSAGE);
        printer.print(getGamersExpression(resultMessage.getGamers()));
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
        List<String> ladderLines = IntStream.range(START_COUNT, ladder.getCellSize())
          .mapToObj(i -> EMPTY_STRING)
          .collect(Collectors.toList());
        AtomicInteger increase = new AtomicInteger(START_COUNT);
        ladder.getStream().forEach(line -> {
            increase.set(START_COUNT);
            line.getStream().forEach(cell -> 
                ladderLines.set(increase.get(), ladderLines.get(increase.getAndIncrement()) + getLine(cell))
            );
        });
        ladderLines.forEach(printer::print);
    }
    
    private String getLine(Cell cell) {
        if (cell.isRightConnected()) {
            return LADDER_VERTICAL + LADDER_HORIZON_LINE;
        }
        return LADDER_VERTICAL + LADDER_HORIZON_EMPTY;
    }
}
