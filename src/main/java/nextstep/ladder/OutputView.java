package nextstep.ladder;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();

    public static void printLadder(PersonNames personNames, Ladder ladder) {
        sb.setLength(0);

        appendPersonNames(personNames);
        appendLadder(ladder);

        System.out.println(sb);
    }

    private static void appendPersonNames(PersonNames personNames) {
        for (Name name : personNames) {
            sb.append(name).append("  ");
        }
        sb.append("\n");
    }

    private static void appendLadder(Ladder ladder) {
        for (Line line : ladder) {
            sb.append("   |");
            appendLine(line);
            sb.append("\n");
        }
    }

    private static void appendLine(Line line) {
        for (Boolean hasLine : line.points()) {
            if(hasLine) {
                sb.append("-----");
                sb.append("|");
            }

            if(!hasLine) {
                sb.append("     ");
                sb.append("|");
            }
        }
    }
}
