package nextstep.view;

import nextstep.dto.LadderDTO;

import java.util.List;

public class ResultView {

    private static final String NAME_FORMAT = "%6s";
    private static final String PEDAL = "-----|";
    private static final String NO_PEDAL = "     |";

    public void printEntryNames(LadderDTO ladderDTO) {
        ladderDTO.getEntryNames().stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(System.out::print);
        System.out.println();
    }

    public void printResult(LadderDTO ladderDTO) {
        ladderDTO.getResult().forEach(this::printPedals);
    }

    private void printPedals(List<Boolean> line) {
        line.forEach(hasPedal -> System.out.print(hasPedal ? PEDAL : NO_PEDAL));
        System.out.println();
    }
}
