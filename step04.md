## 피드백
- Collections.unmodifiableList() 활용
- 네이밍 좀 더 신경쓰기
- 빌더 패턴의 단점이라고 하면 .build()를 호출하는순간 객체 생성이 완료되는 구조이기에 완성되지 않은
  객체를 누군가 사용할 수 있다는 점인 것 같아요! 그렇기에 해당 리뷰를 드리면서 build()가 되기까지 term이 존재하여 구성 과정에서 일관성이 없는 상태에서 사용될 수 있다는 단점
- `!target.equals("all")` equals 를 쓸 때 메서드 대상이 null 이 아닌지 확인
- 해당 Ladder 객체를 은영님이 아닌 동료가 사용할 경우 List<List<Boolean>> 라는 반환값은
  어떤 값을 의미하는지 헷갈릴 것 같아요 😄
- 사다리 결과를 객체로 분리 private final List<Integer> resultTable;
- if 문의 내부가 한 문장일 경우에도 중괄호로 둘러싸는게 컨벤션
- DisplayName 의 목적은 테스트 클래스 또는 테스트 방법에 대한 값이나 설명을 선언하는 데 사용되는것이 목적이기에 기능 정의는 DisplayName 이 아닌 별도로 정의해주시면 어떨까 합니다..!!

