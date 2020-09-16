package nextstep.controller;

import nextstep.dto.EntriesDTO;
import nextstep.dto.EntryDTO;
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
        Personnel personnel = Personnel.of(startEntriesDTO.getEntryCount());

        EntriesDTO arrivalEntriesDTO = inputView.inputArrivalEntries(personnel.getPersonnel());
        LengthDTO lengthDTO = inputView.inputLength();
        Length length = Length.of(lengthDTO.getLength());

        LadderGame ladderGame = LadderGame.of(startEntriesDTO.getEntryNames(), length);
        LadderDTO ladderDTO = new LadderDTO(ladderGame.getLinesStatus());

        resultView.printEntryNames(startEntriesDTO);
        resultView.printLadder(ladderDTO);
        resultView.printEntryNames(arrivalEntriesDTO);

        EntriesDTO targetEntriesDTO = null;
        while (checkAll(targetEntriesDTO)) {
            targetEntriesDTO = inputView.inputTargetEntries(startEntriesDTO);
            printResults(targetEntriesDTO, arrivalEntriesDTO, ladderGame);
        }
    }

    private static void printResults(EntriesDTO targetEntriesDTO, EntriesDTO arrivalEntriesDTO, LadderGame ladderGame) {
        resultView.printBeforePlay();
        targetEntriesDTO.getEntries().forEach(targetEntryDTO -> {
            Entry arrivalEntry = ladderGame.play(targetEntryDTO.getName(), arrivalEntriesDTO.getEntryNames());
            resultView.printPlayResult(targetEntryDTO, new EntryDTO(arrivalEntry.getName()));
        });
    }

    private static boolean checkAll(EntriesDTO targetEntries) {
        return Objects.isNull(targetEntries) || targetEntries.getEntryCount() == 1;
    }
}
