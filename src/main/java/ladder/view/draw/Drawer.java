package ladder.view.draw;

@FunctionalInterface
public interface Drawer<T> {

	String execute(T t);
}
