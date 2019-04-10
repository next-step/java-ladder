package x_dummy;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //사용자입력
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = scanner.nextLine().split(",");
        List<User> users = new ArrayList<>();
        for (String name : names) {
            users.add(new User(name));
        }

        //사다리 높이 입력
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = Integer.parseInt(scanner.nextLine());

        //사다리 생성
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight ; i++) {
            ladder.add(new Line(users.size()));
        }



        //maxMargin을 구해서 그 margin으로 통일해서 뽑자!
        int maxMargin = 0;
        for (User user : users) {
            if (user.margin() > maxMargin) {
                maxMargin = user.margin();
            }
        }

        //결과출력
        for (User user : users) {
            System.out.print(user.toString(maxMargin));
        }
        System.out.println();

        for (Line line : ladder) {
//            String lineView = "";
//            lineView += line.toString(maxMargin); //users를 전달할수도 있겠다
            System.out.println(line.toString(maxMargin));
        }
    }
}

class User {
    private String name;

    public User(String name) {
        validation(name);
        this.name = name;
    }

    private boolean validation(String name) {
        if (name.length() <= 0 || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int margin() {
        return name.length();
    }

    public String toString(int margin) {
        String nameView = StringUtils.repeat(" ", margin - margin() + 1) + name;
        return nameView;
    }
}

class Pair {
    private boolean left;
    private boolean right;

    public Pair(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}

class Line {
    private List<Pair> pairs;

    public Line(int userCount) {
        pairs = new ArrayList<>();
        generate(userCount);
    }

    private void generate(int userCount) {
        boolean left = Boolean.FALSE;
        boolean right = bridge();

        pairs.add(addPair(left, right));

        for(int i=1 ; i < userCount - 1 ; i++) {
            left = right;

            if (left) {
                right=false;
                pairs.add(addPair(left, right));
                continue;
            }

            right = bridge();
            pairs.add(addPair(left, right));
        }

        pairs.add(addPair(right, Boolean.FALSE));
    }

    private boolean bridge() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private Pair addPair(boolean left, boolean right) {
       return new Pair(left, right);
    }

    public String toString(int margin) {
        String view = "";
        for (Pair pair : pairs) {
            if (pair.isLeft()) {
                view += StringUtils.repeat("-", margin);
                view += "|";
                continue;
            }

            view += StringUtils.repeat(" ", margin);
            view += "|";
        }
        return view;
    }
}