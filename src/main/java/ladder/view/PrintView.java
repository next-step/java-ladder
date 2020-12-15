package ladder.view;

import ladder.domain.*;
import ladder.dto.MappingWinningDTO;

import java.util.List;

public class PrintView {

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

    public void printLadder(LadderLine points) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("|");
        stringBuilder.append(RepeatPoint(points.getPoints()));
        stringBuilder.append("\n");

        System.out.print(stringBuilder);
    }

    private String RepeatPoint(List<LadderPoint> points) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < points.size() - 1; i++) {
            stringBuilder.append(checkDivisionLadder(points.get(i).getDirection().isRight()));
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

    public void printWinnings(List<LadderWinning> winnings) {
        StringBuilder stringBuilder = new StringBuilder();

        for (LadderWinning winning : winnings) {
            stringBuilder.append(winning.getWinning() + NON_HAVE_LINE);
        }

        System.out.println(stringBuilder);
    }

    public void printWinningResult(List<MappingWinningDTO> paramList){
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println(EXECUTION_RESULT);
        for(MappingWinningDTO dto : paramList){
            stringBuilder.append(dto.getName() + " : " + dto.getWinning() + "\n");
        }
        System.out.println(stringBuilder);
    }
}