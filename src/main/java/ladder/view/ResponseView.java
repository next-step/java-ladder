package ladder.view;

import ladder.dto.response.LadderDto;
import ladder.view.printable.LadderPrintable;

public class ResponseView {

    private ResponseView() {}

    public static void printLadder(LadderDto ladderDto) {
        new LadderPrintable(ladderDto).print();
    }
}
