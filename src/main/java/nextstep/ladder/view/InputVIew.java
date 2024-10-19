package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputVIew {
    static Scanner SC = new Scanner(System.in);
    public static List<String> inputPlayers(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(SC.nextLine().split(","))
                .collect(Collectors.toList());
    }
}
