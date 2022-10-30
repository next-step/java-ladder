# 사다리 게임

## 1단계 - 자바8 스트림, 람다, Optional

### 요구사항

- Optional을 활용해 조건에 따른 반환리
  - nextstep.optional.User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.
  - 같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현한다. 메소드 인자로 받은 User를 Optional로 생성하면 stream의 map, filter와 같은 메소드를 사용하는 것이 가능하다.
- Optional에서 값을 반환
  - nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
  - 자바 8의 stream과 Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과해야 한다.  
- Optional에서 exception 처리
  - nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다. 
  - 단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.
