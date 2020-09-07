package nextstep.controller;

import nextstep.dto.EntriesDTO;
import nextstep.dto.LadderDTO;
import nextstep.dto.LengthDTO;
import nextstep.entity.Entries;
import nextstep.entity.Ladder;
import nextstep.entity.Length;
import nextstep.entity.Personnel;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class Controller {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        EntriesDTO startEntriesDTO = inputView.inputStartEntries();
        Entries startEntries = EntriesDTO.of(startEntriesDTO);
        Personnel personnel = new Personnel(startEntries.getPersonnel());

        EntriesDTO resultEntriesDTO = inputView.inputResultEntries(personnel.getPersonnel());

        LengthDTO lengthDTO = inputView.inputLength();
        Length length = LengthDTO.of(lengthDTO);

        Ladder ladder = new Ladder(personnel, length);
        LadderDTO ladderDTO = new LadderDTO(ladder);

        resultView.printEntryNames(startEntriesDTO);
        resultView.printLadder(ladderDTO);
        resultView.printEntryNames(resultEntriesDTO);
    }
}
