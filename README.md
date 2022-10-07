# 기능 구현 목록

### 입력
- [x] 사람의 이름을 입력한다.
  - [x] 입력한 값을 반환한다.
  - [x] 쉼표로 사람 이름을 구분한다.
  - [x] 최대 5글자까지 부여할 수 있다.
  - [x] 알파벳이어야 한다.
  - [x] null, "" 입력은 입력할 수 없다.
- [x] 최대 사다리 높이를 입력한다.
  - [x] 입력한 값을 반환한다.
  - [x] 숫자만 입력해야 한다.
  - [x] null, "" 입력은 입력할 수 없다.
  - [x] 그냥 0 또는 두 자릿수 이상에서 첫번째 자리에 0을 입력할 수 없다.
  - [x] 음수는 입력할 수 없다.
- [x] 실행 결과 입력
  - [x] 입력한 값을 반환한다.
  - [x] 쉼표로 사람 이름을 구분한다.
  - [x] null, "" 입력은 입력할 수 없다.
  - [x] 특수문자 입력 불가
  - [x] 사람 수와 같은 개수만 입력할 수 있다.
- [ ] 결과 보고 싶은 사람 입력
  - [ ] 입력 값 반환
  - [ ] 존재하는 사람 또는 all 만 입력 가능

### 출력
- [x] 사다리를 출력한다.
  - [x] 사람 이름을 사다리 위에 같이 출력한다.
  - [x] 사다리의 폭은 9로 설정한다. (이름이 5자 까지 가능하기에 6 이상이어야 한다.)
- [x] 실행 결과도 사다리 출력 시 같이 출력
- [ ] 결과 보고 싶은 사람 출력
  - [ ] 해당 사람의 결과 출력
  - [ ] all 입력 시 모든 결과 출력

### 도메인
- [x] 사다리의 라인을 설정한다.
  - [x] 사다리를 생성한다.
  - [x] 가로라인이 겹치지 않아야 한다.
  - [x] 가로라인의 맨 끝은 무조건 부분 라인이 없어야 한다.
- [x] 각 사람의 사다리 결과 계산하기
  - [x] 맨 마지막 사람은 오른쪽 방향 제외하고 탐색하기.