package ladder.view;

public class UserConsoleView {
    private final Displayer userDisplayer;

    public UserConsoleView(final Displayer userDisplayer) {
        this.userDisplayer = userDisplayer;
    }
    
    public void show() {
        System.out.println("사다리 결과");
        userDisplayer.show((String name) -> System.out.println(name));
    }
}
