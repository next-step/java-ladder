package ladder.controller;

import ladder.domain.HorizontalLines;
import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(InputView.getParticipantInputText());
        String nameString = scanner.nextLine();

        System.out.println(InputView.getLadderHeightInputText());
        int ladderHeight = scanner.nextInt();

        Names names = Names.of(nameString);

        // TODO: Ladder 생성시 사다리가 인접하지 않게 생성되도록 구현한다.
        // Ladder ladder = new Ladder(names.size(), ladderHeight);

        // 임시로 높이 5의 사다리를 생성하도록 하드코딩 했다.
        List<HorizontalLines> horizontalLinesList = new ArrayList<>();
        horizontalLinesList.add(HorizontalLines.of(Arrays.asList(false, true, false, true)));
        horizontalLinesList.add(HorizontalLines.of(Arrays.asList(false, false, true, false)));
        horizontalLinesList.add(HorizontalLines.of(Arrays.asList(false, true, false, false)));
        horizontalLinesList.add(HorizontalLines.of(Arrays.asList(false, false, true, false)));
        horizontalLinesList.add(HorizontalLines.of(Arrays.asList(false, true, false, true)));
        Ladder ladder = Ladder.of(horizontalLinesList);

        System.out.println(ResultView.getDefaultResultText());
        System.out.println(ResultView.getNamesView(names));
        System.out.println(ResultView.getLadderView(ladder));
    }
}
