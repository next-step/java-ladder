package ladder.domain.user;

public class User {
	private final String name;

	public User(String name) {
		this.name = name;
	}

	public static User createUser(String name) {
		if(name == null || name.isEmpty()){
			throw new IllegalArgumentException("이름은 null이나 빈 문자열이 될 수 없습니다.");
		}
		if(name.length() > 5){
			throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
		}
		return new User(name);
	}
}
