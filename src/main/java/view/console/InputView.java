package view.console;

import domain.ladder.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static List<Player> names(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner sc = new Scanner(System.in);
        List<Player> players = Arrays.stream(sc.nextLine().split(",")).map(name -> new Player(name)).collect(Collectors.toList());
        return players;
    }

    public static List<String> result(){
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner sc = new Scanner(System.in);
        return Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());
    }

    public static String resultPlayer() {
        System.out.println("\n결과를 보고 싶은 사람은?\n");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
        return playerName;
    }

    public static LadderLevel getLevel() {
        System.out.println("\n실행할 사다리의 난이도는?");
        Scanner sc = new Scanner(System.in);
        String level = sc.nextLine();
        return LadderLevel.findLevel(level);
    }

    public static List<LadderLine> createLadder(List<Player> players, LadderLevel ladderLevel) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for(int i = 0; i < ladderLevel.getLadderCount(); i++){
            ladderLines.add(LadderLine.init(players.size(), ladderLevel.getRandom()));
        }
        return ladderLines;
    }
}
