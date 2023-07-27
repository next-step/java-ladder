package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningItems {

    private static final int NAME_PRINT_LENGTH = 7;
    private static final String BLANK = " ";

    private final List<WinningItem> winningItems;

    public WinningItems(int countOfPlayers, List<WinningItem> winningItems) {
        winningItemsRangeCheck(countOfPlayers, winningItems);

        this.winningItems = winningItems;
    }

    public WinningItems(int countOfPlayers, String... winningItems) {
        this(countOfPlayers, Arrays.stream(winningItems).map(WinningItem::new).collect(Collectors.toList()));
    }

    private void winningItemsRangeCheck(int countOfPlayers, List<WinningItem> winningItems) {
        if (countOfPlayers != winningItems.size()) {
            throw new IllegalArgumentException("참여자 수와 당첨 항목 수는 같아야 합니다.");
        }
    }

    public WinningItem getWinningItem(int playerIndex) {
        return winningItems.get(playerIndex);
    }

    @Override
    public String toString() {
        return this.winningItems.stream()
                .map(this::nameForPrint)
                .collect(Collectors.joining(""));
    }

    private String nameForPrint(WinningItem winningItem) {
        String name = winningItem.toString();

        return BLANK.repeat(NAME_PRINT_LENGTH - name.length()) + name;
    }
}
