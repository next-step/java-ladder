package ladder.view;

import ladder.domain.Player;
import ladder.domain.Players;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String JOIN_MEMBERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final String MAX_LADDER_COUNT = "최대 사다리 높이는 몇 개인가요?";

    public Players getJoinMembers(){
        System.out.println(JOIN_MEMBERS);
        String inputStr = SCANNER.nextLine();
        List<String> memberList = List.of(inputStr.split(","));
        List<Player> members = new ArrayList<>();
        for(String str : memberList){
            Player player = new Player(str);
            members.add(player);
        }
        return new Players(members);
    }

    public int getLadderCount(){
        System.out.println(MAX_LADDER_COUNT);
        return SCANNER.nextInt();
    }

}
