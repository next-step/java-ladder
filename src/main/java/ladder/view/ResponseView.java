package ladder.view;

import ladder.dto.ResultDto;
import ladder.dto.response.AllResultsDto;
import ladder.dto.response.LadderDto;
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
