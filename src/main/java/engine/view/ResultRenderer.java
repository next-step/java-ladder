package engine.view;

import ladder.LadderResultItem;

import java.util.List;

/**
 * 결과 아이템 출력과 관련된 메서드 제공
 */
public class ResultRenderer {
    private ResultRenderer() {
    }

    /**
     * 결과 아이템을 출력합니다.
     * 공간을 지정해서 정렬된 상태로 출력됩니다.
     *
     * @param resultItems 출력할 결과 아이템 목록
     */
    public static void printResult(List<LadderResultItem> resultItems, int width) {
        final int COLUMN_SYMBOL_LENGTH = 1;

        for (LadderResultItem resultItem : resultItems) {
            MessageRenderer.simplePrintWithWidth(resultItem.toPrintableString(), width + COLUMN_SYMBOL_LENGTH);
        }
        MessageRenderer.newLine();
    }
}
