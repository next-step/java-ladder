package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 사다리를 출력하는 메서드 제공
 */
public class LadderRenderer {
    private final static String COLUMN_SYMBOL = "|";
    private final static String CONNECTION_SYMBOL = "------";
    private final static String NO_CONNECTION_SYMBOL = "      ";

    /**
     * 사다리를 출력합니다.
     *
     * @param ladder 출력할 사다리
     */
    public static void printLadder(Ladder ladder) {
        List<String> ladderLineStrings = ladder.toList().stream()
                .map(LadderRenderer::ladderLineToLineString)
                .collect(Collectors.toList());

        for (String ladderLineString : ladderLineStrings) {
            MessageRenderer.simplePrint(ladderLineString);
        }
    }

    private static String ladderLineToLineString(LadderLine ladderLine) {
        StringBuilder st = new StringBuilder();
        for (int columnIndex = 0; columnIndex < ladderLine.howManyColumns() - 1; columnIndex++) {
            st.append(COLUMN_SYMBOL);
            if (ladderLine.isConnected(columnIndex)) {
                st.append(CONNECTION_SYMBOL);
            }
            else {
                st.append(NO_CONNECTION_SYMBOL);
            }
        }
        st.append(COLUMN_SYMBOL);
        return st.toString();
    }
}