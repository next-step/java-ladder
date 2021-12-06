## STEP 2
### 1차 피드백
- 생성자가 아닌 팩토리 메소드에서 로직을 통한 생성은 괜찮은 것 같다.
- RandomLineStrategy 을 매번 생성하는 부분을 한 번 생성으로 변경
- view, util과 같은 생성자를 만들 필요가 없는 클래스는 private 생성자로 생성자가 생기는 걸 방지하기
```
같은 실수를 반복하지 말자..!
```
- static 메소드 경우 class명을 통해 람다 가능
```
this::lineFormat == ResultView::lineFormat
```
- 라인이 곂치지 않는지에 대한 테스트 작성
