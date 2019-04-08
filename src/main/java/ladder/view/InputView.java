package ladder.view;

import ladder.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public List<String> printInputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        String[] names = Utils.stringSplitWithDelimiter(inputValue, ",");
        for (String name : names) {
            checkNameLength(name);
        }
        return Arrays.asList(names);
    }

    public int printInputLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        return Integer.parseInt(inputValue);
    }

    private void checkNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름의 최대길이는 5자입니다.");
        }
    }
}
