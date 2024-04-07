# 🚀 2단계 - 사다리(생성)
## 기능 목록
- User
  - [x] 이름이 null, 공백 및 빈값인 경우 예외 발생

- Users
  - [ ] 유저들의 수를 반환
  - [ ] 크기가 0이거나 비어있으면 예외 발생

- Point
  - [ ] 이어져 있는지 여부 확인을 위한 값이 null인 경우 예외 발생
  - [ ] 자신의 상태를 반환 해야함.

- Line(가로 선) : Point의 List
  - [ ] n-1 번째 이어진 경우 n번째는 이어질 수 없음.
  - [ ] 사람 수 - 1 만큼 사다리 폭이 결정된다.
  - [ ] 사다리 폭은 1보다 작은 경우 예외 발생

- Lines : Line의 List
  - [ ] 높이가 1보다 작은 경우 예외 발생

## 프로그래밍 요구사항
- 스트림과 람다를 적용
- 모든 엔티티를 작게 유지