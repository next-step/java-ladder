package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInput {
    private static final Pattern NAMES = Pattern.compile("[,]");
    
    private final Scanner input;

    public UserInput() {
        input = new Scanner(System.in);
    }

    public List<String> getUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요.(이름은 쉼표(,)로 구분하세요)");
        return toNames(input.next());
    }

    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
        int height = input.nextInt();
        if (height < 1) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return height;
    }
    
    private static List<String> toNames(final String names) {
        String[] nameArr = NAMES.split(names);
        return new ArrayList<>(Arrays.asList(nameArr));
    }
}
