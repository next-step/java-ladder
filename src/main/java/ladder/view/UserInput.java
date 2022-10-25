package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import ladder.domain.Height;
import ladder.domain.UserNames;

public class UserInput {
    private static final Pattern NAMES = Pattern.compile("[,]");
    
    private final Scanner input;

    public UserInput() {
        input = new Scanner(System.in);
    }

    public UserNames userNames(int maxNameLength) {
        System.out.println("참여할 사람 이름을 입력하세요.(이름은 쉼표(,)로 구분하세요)");
        return names(names(), maxNameLength);
    }

    public Height height() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
        return new Height(input.nextInt());
    }
    
    private UserNames names(final String names, final int maxNameLength) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        return new UserNames(toNames(names, maxNameLength));
    }

    private static List<String> toNames(final String names, final int maxNameSize) {
        String[] nameArr = NAMES.split(names);
        List<String> result = new ArrayList<>();
        for (String name : nameArr) {
            result.add(name(name, maxNameSize));
        }
        return result;
    }

    private static String name(final String name, final int maxNameSize) {
        if (name.length() > maxNameSize) {
            throw new IllegalArgumentException("The maximum length of a name cannot exceed "+ maxNameSize +" characters.");
        }
        return name;
    }

    String names() {
        return input.next();
    }
}
