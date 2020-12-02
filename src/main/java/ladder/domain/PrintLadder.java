package ladder.domain;

import java.util.List;

public class PrintLadder {


    private static final String HAVE_LINE = "-----";
    private static final String NON_HAVE_LINE = "     ";
    private static String plusNonhaveLine = "";
    private static String plusHaveLine = "";

    public void printNames(List<String> names) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < names.size(); i++) {
            sb.append(checkDivisionNames(i == names.size() - 1, names.get(i)));
        }

        System.out.println(sb);
    }

    private String checkDivisionNames(boolean last, String name) {
        StringBuilder sb = new StringBuilder();

        if (last) {
            sb.append(name);
            return sb.toString();
        }

        sb.append(name + "   ");

        return sb.toString();
    }


    public void printLadder(List<Boolean> points, int lineSize) {
        addLineSize(lineSize);

        StringBuilder sb = new StringBuilder();
        sb.append(plusNonhaveLine);
        sb.append("|");

        for (Boolean point : points) {
            sb.append(checkDivisionLadder(point));
            sb.append("|");
        }
        System.out.println(sb);
    }

    public String checkDivisionLadder(boolean point) {
        String returnValue = "";

        if (point) {
            return HAVE_LINE + plusHaveLine;
        }

        if (!point) {
            return NON_HAVE_LINE + plusNonhaveLine;
        }

        return returnValue;
    }

    public void addLineSize(int lineSize) {
        StringBuilder haveSb = new StringBuilder();
        StringBuilder nonSb = new StringBuilder();

        for (int i = 0; i < lineSize / 2; i++) {
            nonSb.append(" ");
            haveSb.append("-");
        }

        this.plusNonhaveLine = nonSb.toString();
        this.plusHaveLine = haveSb.toString();
    }
}
