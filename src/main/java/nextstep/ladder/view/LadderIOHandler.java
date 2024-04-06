package nextstep.ladder.view;

import nextstep.ladder.domain.Destination;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class LadderIOHandler {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderIOHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printLadder(List<Participant> participants, Lines entireLines, List<Destination> destinations){
        outputView.printLadderResult();
        outputView.printMessage(getHeader(participants));
        outputView.printMessage(getLadder(entireLines));
        outputView.printMessage(getBottom(destinations));
    }

    private String getHeader(List<Participant> participants) {
        return participants
                .stream()
                .map(iter -> prependSpace(iter.getName()))
                .collect(Collectors.joining(" "));
    }

    public String getBottom(List<Destination> destinations) {
        return destinations
                .stream()
                .map(iter -> prependSpace(iter.getDestination()))
                .collect(Collectors.joining(" "));
    }

    private String getLadder(Lines entireLines){
        List<Line> lines = entireLines.getLines();
        StringBuilder sb = new StringBuilder();
        for(Line line : lines) {
            sb.append("     |");
            printPoints(sb, line.getLine());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private void printPoints(StringBuilder sb, List<Boolean> points) {
        for(Boolean point : points){
            sb.append(getPoint(point));
        }
    }

    private String prependSpace(String value){
        if(value.length() >= 5){
            return value;
        }
        String substring = "     ".substring(0, 5 - value.length());
        return substring + value;
    }

    private String getPoint(Boolean point){
        if(point){
            return "-----|";
        }
        return "     |";
    }
}
