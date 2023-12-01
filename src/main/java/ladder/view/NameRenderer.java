package ladder.view;

import ladder.domain.Name;

import java.util.List;

/**
 * 이름 출력과 관련된 메서드 제공
 */
public class NameRenderer {
    private NameRenderer() {
    }

    /**
     * 이름을 출력합니다.
     * 이름은 공간을 지정해서 정렬된 상태로 출력됩니다.
     *
     * @param names 출력할 이름 목록
     */
    public static void printNames(List<Name> names, int width) {
        final int COLUMN_SYMBOL_LENGTH = 1;

        for (Name name : names) {
            MessageRenderer.simplePrintWithWidth(name.toPrintableString(), width + COLUMN_SYMBOL_LENGTH);
        }
        MessageRenderer.newLine();
    }
}
