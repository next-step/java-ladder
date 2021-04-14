package nextstep.refactoring.view.console;

import nextstep.refactoring.ladder.engine.dto.LadderDto;
import nextstep.refactoring.ladder.engine.dto.LineDto;
import nextstep.refactoring.view.interfaces.ResultView;

import java.util.List;

import static nextstep.ladder.util.StringUtils.repeat;

public class ConsoleResultView implements ResultView {

    private static final int STRING_ELEMENT_SIZE = 5;
    private static final String POINT = "|";
    private static final String WHITE_SPACE = " ";
    private static final String HYPHEN = "-";

    @Override
    public void printLadder(LadderDto ladderDto) {
        ladderDto.lineDtoList()
                 .stream().map(LineDto::connectionList)
                 .map(this::depictConnections)
                 .forEach(System.out::println);
    }

    private String depictConnections(List<Boolean> connections) {
        StringBuilder stringBuilder =  new StringBuilder(repeat(WHITE_SPACE, STRING_ELEMENT_SIZE - 1) + POINT);

        connections.stream()
                   .map(connection -> repeat(selectSymbol(connection), STRING_ELEMENT_SIZE) + POINT)
                   .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private String selectSymbol(boolean connection) {
        return connection ? HYPHEN : WHITE_SPACE;
    }

}
