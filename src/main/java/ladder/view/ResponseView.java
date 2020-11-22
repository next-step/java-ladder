package ladder.view;

import ladder.dto.AllResultsDto;
import ladder.dto.LadderDto;
import ladder.dto.ResultDto;
import ladder.view.printable.AllResultsPrintable;
import ladder.view.printable.LadderPrintable;
import ladder.view.printable.ResultPrintable;

public class ResponseView {

    private ResponseView() {}

    public static void printLadder(LadderDto ladderDto) {
        new LadderPrintable(ladderDto).print();
    }

    public static void printResult(ResultDto resultDto) {
        new ResultPrintable(resultDto).print();
    }

    public static void printAllResults(AllResultsDto allResultsDto) {
        new AllResultsPrintable(allResultsDto).print();
    }
}
