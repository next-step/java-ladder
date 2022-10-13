package nextstep.laddergame.view;

import nextstep.laddergame.domain.Gamer;
import nextstep.laddergame.domain.Height;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_GAMER_NAMS_STRING = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\"";
    private static final String NAME_SEPARATE = ",";
    private static final String INPUT_LADDER_HEIGHT_STRING = "\n최대 사다리 높이는 몇 개인가요?";

    public static List<Gamer> inputGamerNames() {
        System.out.println(INPUT_GAMER_NAMS_STRING);
        Scanner scanner = new Scanner(System.in);
        String gamerNamesString = scanner.nextLine();
        return Arrays
                .stream(gamerNamesString.split(NAME_SEPARATE))
                .map(Gamer::new)
                .collect(Collectors.toList());
    }

    public static Height inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_STRING);
        Scanner scanner = new Scanner(System.in);
        String ladderHeightString = scanner.nextLine();
        return new Height(ladderHeightString);
    }


}
