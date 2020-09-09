package nextstep.controller;

import nextstep.dto.EntriesDTO;
import nextstep.dto.LadderDTO;
import nextstep.dto.LengthDTO;
import nextstep.entity.*;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class Controller {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        EntriesDTO startEntriesDTO = inputView.inputStartEntries();
        Entries startEntries = Entries.of(startEntriesDTO.getEntryNames());
        Personnel personnel = Personnel.of(startEntries.getPersonnel());

        EntriesDTO arrivalEntriesDTO = inputView.inputArrivalEntries(personnel.getPersonnel());
        Entries arrivalEntries = Entries.of(arrivalEntriesDTO.getEntryNames());

        LengthDTO lengthDTO = inputView.inputLength();
        Length length = Length.of(lengthDTO.getLength());

        Ladder ladder = Ladder.of(personnel, length);
        LadderDTO ladderDTO = new LadderDTO(ladder);
        PlayResults playResults = ladder.play(startEntries, arrivalEntries);

        resultView.printEntryNames(startEntriesDTO);
        resultView.printLadder(ladderDTO);
        resultView.printEntryNames(arrivalEntriesDTO);

        EntriesDTO targetEntriesDTO = inputView.inputTargetEntries(startEntriesDTO);
        resultView.printPlayResults(targetEntriesDTO, playResults);
    }
}
