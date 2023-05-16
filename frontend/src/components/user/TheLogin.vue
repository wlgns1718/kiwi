<template>
  <div>
    KIWI는 자신만이 간직한 아름다운 여행지를<br />
    공유하는 커뮤니티 사이트입니다.

    <div class="Sign_Wrap">
      <div class="signin">
        <h2>로그인</h2>
        <div>
          <input type="text" class="input" placeholder="아이디를 입력하세요." />
          <input
            style="margin: 10px 0 0 0"
            type="password"
            class="input"
            placeholder="비밀번호를 입력하세요."
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.Sign_Wrap {
  margin: auto;
  margin-top: 80px;
  width: 300px;
  border: 2px;
  border-style: solid;
  border-radius: 12px 12px 12px 12px;
  background-color: rgb(255, 255, 255);
}
.signin {
  text-align: left;
  padding: 20px;
}
.input {
  border-radius: 6px 6px 6px 6px;
  font-size: 16px;
  font-weight: normal;
  border: 1px solid;
  border-color: #e5e6e9;
  width: 100%;
  box-sizing: border-box;
  line-height: 23px;
  padding: 10px 0 10px 5px;
  margin: 30px 0 0 0;
}
.input:focus {
  border: 2px solid;
  border-color: rgb(8, 234, 50);
  outline: none;
}
h2 {
  margin: 0;
}
</style>
