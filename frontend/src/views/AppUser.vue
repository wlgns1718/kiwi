<template>
  <div>
    <!-- <h1 class="header">KIWI에 오신것을 환영합니다!!</h1> -->
    <h1 class="header">KIWI</h1>
    KIWI는 자신만이 간직한 아름다운 여행지를<br />
    공유하는 커뮤니티 사이트입니다.
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "UserView",
  components: {},
  data() {
    return {};
  },
};
</script>

<style scoped>
.header {
  margin-top: 100px;
  color: rgb(105, 228, 128);
}
div {
  text-align: center;
}
</style>
