package laddergame.utilForTest;

import laddergame.domain.WinningContent;
import laddergame.domain.WinningContents;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningContentsUtilForTest {
    private WinningContentsUtilForTest() {
    }

    public static WinningContents newWinningContents(String... winningContents) {
        return new WinningContents(Arrays.stream(winningContents)
                .map(WinningContent::new)
                .collect(Collectors.toList()));
    }

    public static WinningContents newWinningContents(WinningContent... winningContents) {
        return new WinningContents(List.of(winningContents));
    }
}
