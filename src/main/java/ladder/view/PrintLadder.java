package ladder.view;

import ladder.domain.*;

import java.util.List;

public class PrintLadder {
    private static final String HAVE_LINE = "-----";
    private static final String NON_HAVE_LINE = "     ";

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


    public void printLadder(LadderLine ladderLine) {
        StringBuilder stringBuilder = new StringBuilder();
        List<LadderPoints> lll = ladderLine.getLadderLine();

        for (LadderPoints points : lll) {
            stringBuilder.append("|");

            stringBuilder.append(RepeatPoint(points.getPoints()));

            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public String RepeatPoint(List<LadderPoint> points) {
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
}
