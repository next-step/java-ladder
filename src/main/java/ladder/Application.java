package ladder;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        System.out.println(names);
        System.out.println();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = Integer.parseInt(scanner.nextLine());
        System.out.println();

        Random random = new Random();
        List<List<Boolean>> ladder = new ArrayList<>();

        for (int i = 0; i < names.size() - 1; i++) {
            List<Boolean> line = new ArrayList<>();
            if (i == 0) {
                for (int j = 0; j < ladderHeight; j++) {
                    line.add(random.nextInt(6) % 2 == 0);
                }
                ladder.add(line);
            } else {
                for (int j = 0; j < ladderHeight; j++) {
                    if(ladder.get(i-1).get(j)) { // 배치 된 경우
                        line.add(false);
                    }else {  // 배치 안된 경우.
                        line.add(random.nextInt(10) >= 4); // 0 1 2 3 4 | 0 1 0 1 0
                    }
                }
                ladder.add(line);
            }
        }

        System.out.println("실행결과");
        System.out.println();
        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < names.size() - 1; j++) {
                System.out.print(ladder.get(j).get(i) ? "|----" : "|    ");
                if (j == names.size() - 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
