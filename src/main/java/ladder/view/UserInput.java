package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInput {
    private static final Pattern DELIMITER = Pattern.compile("[,]");
    
    private final Scanner input;

    public UserInput() {
        input = new Scanner(System.in);
    }

    public List<String> getUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요.(이름은 쉼표(,)로 구분하세요)");
        return split(input.next());
    }

    public List<String> getResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        return split(input.next());
    }
    
    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
        int height = input.nextInt();
        if (height < 1) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return height;
    }

    public String getUserName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return input.next();
    }
    
    private static List<String> split(final String names) {
        String[] nameArr = DELIMITER.split(names);
        return new ArrayList<>(Arrays.asList(nameArr));
    }
}
