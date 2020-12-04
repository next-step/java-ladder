package ladder.domain;

import ladder.dto.LadderLineDTO;

import java.util.List;

public class PrintLadder {
    private static final String HAVE_LINE = "-----";
    private static final String NON_HAVE_LINE = "     ";

    public void printNames(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < names.size(); i++) {
            stringBuilder.append(checkDivisionNames(i == names.size() - 1, names.get(i)));
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


    public void printLadder(LadderLineDTO ladderLineDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        List<List<Boolean>> ladderLine = ladderLineDTO.getLadderLine();

        for (List<Boolean> line : ladderLine) {
            stringBuilder.append("|");
            for(Boolean ladder : line){
                stringBuilder.append(checkDivisionLadder(ladder));
                stringBuilder.append("|");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public String checkDivisionLadder(boolean point) {
        if (point) {
            return HAVE_LINE;
        }

        return NON_HAVE_LINE;
    }
}
