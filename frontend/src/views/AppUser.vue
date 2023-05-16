<template>
  <div>
    <!-- <h1 class="header">KIWI에 오신것을 환영합니다!!</h1> -->
    <h1 class="header">KIWI</h1>
    <the-login></the-login>
  </div>
</template>

<script>
import TheLogin from "@/components/user/TheLogin.vue";

export default {
  components: {
    TheLogin,
  },
};
</script>

<style scoped>
.header {
  margin-top: 100px;
  color: rgb(8, 234, 50);
}
div {
  text-align: center;
}
</style>
