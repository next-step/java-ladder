package nextstep.controller;

import nextstep.dto.EntriesDTO;
import nextstep.dto.LadderDTO;
import nextstep.dto.LengthDTO;
import nextstep.entity.*;
import nextstep.view.InputView;
import nextstep.view.ResultView;

import java.util.Objects;

public class Controller {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        EntriesDTO startEntriesDTO = inputView.inputStartEntries();
        Entries startEntries = Entries.of(startEntriesDTO.getEntryNames());
        Personnel personnel = Personnel.of(startEntries.getPersonnel());

        EntriesDTO arrivalEntriesDTO = inputView.inputArrivalEntries(personnel.getPersonnel());
        LengthDTO lengthDTO = inputView.inputLength();
        Length length = Length.of(lengthDTO.getLength());

        LadderGame ladderGame = LadderGame.of(startEntries);
        ladderGame.initLadder(length);
        LadderDTO ladderDTO = new LadderDTO(ladderGame.getLinesStatus());

        resultView.printEntryNames(startEntriesDTO);
        resultView.printLadder(ladderDTO);
        resultView.printEntryNames(arrivalEntriesDTO);

        Entries arrivalEntries = Entries.of(arrivalEntriesDTO.getEntryNames());
        printResults(startEntriesDTO, arrivalEntries, ladderGame);
    }

    private static void printResults(EntriesDTO startEntriesDTO, Entries arrivalEntries, LadderGame ladderGame) {
        EntriesDTO targetEntries = null;
        while (checkAll(targetEntries)) {
            targetEntries = inputView.inputTargetEntries(startEntriesDTO);
            resultView.printPlayResults(targetEntries, arrivalEntries, ladderGame);
        }
    }

    private static boolean checkAll(EntriesDTO targetEntries) {
        return Objects.isNull(targetEntries) || targetEntries.getEntryCount() == 1;
    }
}
