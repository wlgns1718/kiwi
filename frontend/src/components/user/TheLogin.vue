<template>
  <div>
    KIWI는 자신만이 간직한 아름다운 여행지를<br />
    공유하는 커뮤니티 사이트입니다.

    <div class="Sign_Wrap">
      <div class="signin">
        <h2>로그인</h2>
        <div>
          <input
            v-model="user.id"
            type="text"
            class="Logininput"
            placeholder="아이디를 입력하세요."
          />
          <input
            v-model="user.password"
            style="margin: 10px 0 0 0"
            type="password"
            class="Logininput"
            placeholder="비밀번호를 입력하세요."
            @keyup.enter="confirm"
          />
          <button class="LoginBtn" @click="confirm">로그인</button>
          <div class="option">
            <input type="checkbox" id="LoginCheckbox" />
            <label for="LoginCheckbox">로그인 상태 유지</label>
            <router-link to="#" class="regist">회원가입</router-link>
          </div>
        </div>
        <div></div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  data() {
    return {
      user: {
        id: null,
        password: null,
      },
    };
  },
  created() {},
  computed: {
    ...mapState("userStore", ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions("userStore", ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      // console.log("1. confirm() token >> " + token);
      if (this.isLogin) {
        await this.getUserInfo(token);
        // console.log("4. confirm() userInfo :: ", this.userInfo);
        this.$router.push({ name: "main" });
      }
    },
  },
};
</script>

<style scoped>
.regist {
  margin: 0 0 0 77px;
}
input[id="LoginCheckbox"] {
  /* display: none; */
}

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
.Logininput {
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
.Logininput:focus {
  border: 2px solid;
  border-color: rgb(105, 228, 128);
  outline: none;
}
h2 {
  margin: 0;
}
.LoginBtn {
  border: 0;
  margin: 30px 0 20px 0;
  width: 100%;
  border-radius: 6px 6px 6px 6px;
  font-weight: bold;
  padding: 10px 0 10px 0;
  font-size: 18px;
  color: rgb(255, 255, 255);
  background-color: rgb(105, 228, 128);
  cursor: pointer;
}
</style>
