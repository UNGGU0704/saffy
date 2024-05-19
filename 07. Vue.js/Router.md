# Router

## Routing

> *네크워크에서 경로 선택 프로세스, 웹 어플리케이션에서 다른 페이지간의 전환과 경로 관리 기술*
> 

### Routing 기술이 없다면?

- 유저가 URL을 통한 페이지 변환 감지 못함
- 브라우저 뒤로 가기 기능 사용 불가
- 페이지가 무엇을 렌더린 중인지 알 수 없음

## Vue Router

```jsx
<RouterLink to="/">Home</RouterLink>
```

- 페이지 다시 로드하지 않고 URL 생성 및 관련 로직 처리

```jsx
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
```

- URL에 해당하는 컴포넌트를 표시
- **router/index.js** : 라우팅과 관련된 정보 및 설정 작성 되는 곳

![Untitled](img/router/Untitled.png)

- 일반 컴포넌트와 구분하기 위해 컴포넌트 이름을 View로 끝나도록 작성하는걸 권장함

### 라우팅 사용

```jsx
const router = createRouter({
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
  ...

  <nav>
    <RouterLink to="/">Home</RouterLink>
    <RouterLink to="/about">About</RouterLink>
  </nav>
```

- index.js에 라우터 관련 설정 작성
- RouterLink의 **to** 속성으로 index.js에서 정의한 주소 속성 값을 사용

```jsx
 <nav>
    <RouterLink to="{ name : 'home' }">Home</RouterLink>
    <RouterLink to="{ name : 'about' }">About</RouterLink>
  </nav>
```

- 하드 코딩된 URL을 사용하지 않아도 된다.
- URL 입력 시 오타 방지

### 동적 경로 매칭

- 사용자 ID를 활용한 페이지 설계시 URL은?
    - `user/1`
    - `user/2`
    - 무한 반복
- 매개변수 `:` 로 표기
    
    ```jsx
    const router = createRouter({
      routes: [
        {
          path: '/user/:id',
          name: 'user',
          component: UserView
        },
    ```
    
    ```jsx
    <h1>UserView</h1>
    <h2>{{ userId }}번 User 페이지
    
    const userId = ref(route.params.id)
    ```
    
    로 호출 가능
    

## Router Navigation

- 다른 위치로 이동하기
    - `router.push()`
- 현재 위치 바꾸기
    - `router.replace()`

### router.push()

- 다른 URL로 이동하는 메서드
- 새 항목을 push하므로 사용자가 브라우저 뒤로가기 버튼을 클릭하면 이전 URL로 이동 가능
- RouterLink를 클릭했을 때 `router.push()` 을 호출하는 것과 같음

### router.replace()

- push와 달리 history stack에 push하는게 아니라 다른 URL로 이동

## Navigation Guard

### router.beforeEach

```jsx
beforeEnter: (to, from, next) => {
        const userId = to.params.userId;
        // userId가 "admin"이 아니면 UserView로의 접근을 금지합니다.
        if (userId !== 'admin') {
          next({ name: 'home' }); // 홈 페이지로 리디렉션합니다.
        } else {
          next(); // 계속 진행합니다.
        }
      }
```

- to : 이동 할 URL 정보가 담긴 Route 객체
- from : 현재 URL 정보가 담긴 Route 객체