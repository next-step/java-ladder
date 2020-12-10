package ladder.view;

import ladder.domain.*;
import ladder.dto.LadderWinningDTO;

import java.util.List;

public class PrintLadder {

    private static final String HAVE_LINE = "-----";
    private static final String NON_HAVE_LINE = "     ";
    private static final String EXECUTION_RESULT = "실행결과";

    public void printNames(Persons persons) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Person> personList = persons.getPersons();

        for (int i = 0; i < personList.size(); i++) {
            stringBuilder.append(checkDivisionNames(i == personList.size() - 1, personList.get(i).getName()));
        }

        System.out.println(stringBuilder);
    }

    private String checkDivisionNames(boolean last, String name) {
        StringBuilder sb = new StringBuilder();

        if (last) {
            sb.append(name);
            return sb.toString();
        }

        sb.append(name + "\t");

        return sb.toString();
    }


    public void printLadder(Ladder ladderLine) {
        StringBuilder stringBuilder = new StringBuilder();
        List<LadderLine> lll = ladderLine.getLadderLine();

        for (LadderLine points : lll) {
            stringBuilder.append("|");

            stringBuilder.append(RepeatPoint(points.getPoints()));

            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }

    private String RepeatPoint(List<LadderPoint> points) {
        StringBuilder stringBuilder = new StringBuilder();

        for (LadderPoint point : points) {
            stringBuilder.append(checkDivisionLadder(point.isLadderPoint()));
            stringBuilder.append("|");
        }

        return stringBuilder.toString();
    }

    private String checkDivisionLadder(boolean point) {
        if (point) {
            return HAVE_LINE;
        }

        return NON_HAVE_LINE;
    }

    public void printWinnings(List<LadderWinning> winnings){
        StringBuilder stringBuilder = new StringBuilder();

        for(LadderWinning winning : winnings){
            stringBuilder.append(winning.getWinning() + NON_HAVE_LINE);
        }

        System.out.println(stringBuilder);
    }

    public void printOneWinningResult(List<LadderWinningDTO> ladderWinningList) {
        System.out.println(EXECUTION_RESULT);
        System.out.println(ladderWinningList.get(0).getResult());
        System.out.println();
    }

    public void printAllWinningResult(List<LadderWinningDTO> ladderWinningList) {
        System.out.println(EXECUTION_RESULT);
        for (LadderWinningDTO dto : ladderWinningList) {
            System.out.println(dto.getName() + " : " + dto.getResult());
        }
    }
}
