package ladder.domain;

import ladder.dto.MappingWinningDTO;
import ladder.view.InputView;
import ladder.view.PrintView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LadderPrint {

    private static PrintView printLadder = new PrintView();
    private LadderGame ladderGame;
    private List<MappingWinningDTO> mappingWinningDTOS = new ArrayList<>();

    public LadderPrint(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
        printBasic();
    }

    public void printBasic() {
        printNames();
        printLadder();
        printWinnings();
    }

    private void printNames() {
        printLadder.printNames(ladderGame.getPerson());
    }

    private void printLadder() {
        List<LadderLine> line = ladderGame.getLadder().getLadderLines();

        for (LadderLine points : line) {
            printLadder.printLadder(points);
        }

    }

    private void printWinnings() {
        printLadder.printWinnings(ladderGame.getWinnings());
    }

    public void resultPrint() {

        for (LadderLine line : ladderGame.getLadder().getLadderLines()) {
            for (LadderPoint point : line.getPoints()) {
                System.out.print(point.getIndex() + " / ");
            }
            System.out.println();
        }

        mappingAllWinnings();
        while (!printwinning()) {
        }
    }

    private String inputDesiredResult() {
        return InputView.wantNameToResult();
    }

    private boolean printwinning() {
        String desiredResult = inputDesiredResult();

        if (desiredResult.equals("all")) {
            printLadder.printWinningResult(mappingWinningDTOS);
            return true;
        }

        printLadder.printWinningResult(Arrays.asList(mappingName(desiredResult).get()));

        return false;
    }

    private List<MappingWinningDTO> mappingAllWinnings() {
        MappingWinningDTO mappingWinningDTO;
        int pointIndex = 0;
        int lastIndex = ladderGame.getLadder().getLadderLines().size() - 1;
        LadderLine lastLine = ladderGame.getLadder().getLadderLines().get(lastIndex);
        List<Person> persons = ladderGame.getPerson().getPersons();
        List<LadderWinning> winnings = ladderGame.getWinnings();

        for (int i = 0; i < lastLine.getPoints().size(); i++) {
            pointIndex = lastLine.getPoints().get(i).getIndex();
            mappingWinningDTO = new MappingWinningDTO(persons.get(i).getName(), winnings.get(pointIndex).getWinning());
            mappingWinningDTOS.add(mappingWinningDTO);
        }

        return mappingWinningDTOS;
    }

    private Optional<MappingWinningDTO> mappingName(String name) {
        return mappingWinningDTOS.stream()
                .filter(dto -> dto.getName().equals(name))
                .findFirst();
    }
}
