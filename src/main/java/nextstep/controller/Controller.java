package nextstep.controller;

import nextstep.dto.EntriesDTO;
import nextstep.dto.LadderDTO;
import nextstep.dto.LengthDTO;
import nextstep.entity.Entries;
import nextstep.entity.Ladder;
import nextstep.entity.Length;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class Controller {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        EntriesDTO entriesDTO = (EntriesDTO) inputView.inputEntries();
        LengthDTO lengthDTO = (LengthDTO) inputView.inputLength();

        Entries entries = entriesDTO.of();
        Length length = lengthDTO.of();

        Ladder ladder = new Ladder(entries, length);
        LadderDTO ladderDTO = new LadderDTO(ladder);

        resultView.printEntryNames(ladderDTO);
        resultView.printResult(ladderDTO);
    }
}
