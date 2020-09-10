package step3.domain;

public class User {
	private final static int MAX_NAME_LENGTH = 5;

	private final String name;

	public User(String name) {
		validUserName(name);
		this.name = name;
	}

	private void validUserName(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("참여자 이름은 최대 5자 까지 입력 가능합니다.");
		}
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
