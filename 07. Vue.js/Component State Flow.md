# Component State Flow

## Passing props

> _부모는 자식에게 데이터를 전달하며, 자신은 자신에게 일어난 일을 부모에게 알림_

![Untitled](img/comimg/Untitled.png)

- 해당 페이지를 구성하는 컴포넌트가 여러개라면 개별적으로 모든 컴포넌트에게 요청해야할까?
- **공통된 부모 컴포넌트에서 관리하면 그럴 필요가 없다!**

## Props

> _부모 컴포넌트로부터 자식 컴포넌트로 데이터를 전달하는데 사용되는 속성_

- 모든 props는 자식속성과 부모 속성 사이에 **하양식 단방향 바이딩**을 형성
  - 즉 부모 → 자식은 가능하지만 자식 → 부모는 불가능하다
  - 자식 컴포넌트에서 props를 변경하는 것은 불가능하다 → FrontEnd는 readonly이다.
- 오직 변경은 부모 컴포넌트만 가능하고 자직은 이것을 자연스럽게 갱신

### Props 선언

> _부모 컴포넌트에서 보낸 props를 사용하기 위해서는 자식 컴포넌트에서 명시적인 props 선언 필요_

- props의 이름을 통해 객체를 생성한다.
- 객체 속성의 값은 값이 될 데이터의 타입에 해당하는 생성자 함수여야한다.

**객체 선언**

```
<script setup>
defineProps({
    myMsg : String
})
</script>

...
{{myMsg}}
```

**만약 한단계 더 밑으로 내려보내고 싶다면?**

```jsx
<mainGrandChild : myMsg = "myMsg" />
```

**Name Convention**

- 선언 및 템플릿 참조 시 → _camelCase_
- 자식 컴포넌트로 전달 시 → _kebab-case_

## Component Events

> _부모는 자식에게 데이터를 전달하지만, 자식은 자신에게 일어난 일을 부모에게 알려 부모가 prop 데이터를 변경하도록 알려야한다._

### $emit()

- 자식 컴포넌트가 이벤트를 발생 시켜 부모 컴포넌트로 데이터 전달하는 역할의 메서드

**이벤트 발신 및 수신**

```jsx
<button @click = "$emit('someEvent')"> 클릭 </button>
```

- 부모의 v-on을 활용한 수신

```jsx
<ParentComp @some-event = "someCallback" />

... (대충 someCallback 콜백 함수)
```

### emit 이벤트 선언

- `defineEmits()` 를 사용하여 명시적으로 이벤트 선언을 하는 것이 가능하다.

  ```jsx
  <script setup>
  const emit = defineEmits(['someEvent', 'myFocus'])

  const buttonClick = function () {
      emit('someEvent')
  }
  </script>

  <button @click ="buttoneClikc"> 클릭 </button>
  ```

  ![Untitled](img/comimg/Untitled%201.png)
