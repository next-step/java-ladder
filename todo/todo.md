###람다 실습

- [x] 익명 클래스를 람다로 전환

- [x] 람다를 활용해 중복 제거
   - [x] 인터페이스 익명 클래스 생성
### 

###스트림 

war-and-peace.txt 파일을 읽어 다음 요구사항을 만족

- [x] **실습 1.** 
  - List에 담긴 모든 숫자 중 3보다 큰 숫자를(`filter`), 2배 한 후(`map`), 합을(`reduce`) 구한다. 
  지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.
- [x] nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.

- [x] **실습 2.** 
  - nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다. 요구사항은 다음과 같다.

- [x] 단어의 길이가 12자를 초과하는 단어를 추출한다.(`filter`)
- [x] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.(`sort?`, `filter?`)
- [x] 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.(`?`)
- [x] 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.(`collect`, `map`)

### 

### Optional
- [x] 요구사항 1 - Optional을 사용해 조건에 따른 반환

- [x] 요구사항 2 - Optional에서 값을 반환

- [x] 요구사항 3 - Optional에서 exception 처리

- [] 추가 ComputerStore 테스트 커버리지 확보위한 리팩토링





