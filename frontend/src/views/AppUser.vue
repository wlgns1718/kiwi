<template>
  <div>
    <!-- <h1 class="header">KIWI에 오신것을 환영합니다!!</h1> -->
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
