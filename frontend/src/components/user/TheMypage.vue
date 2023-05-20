<template>
  <div class="view-content">
    <h3 class="app_title">마이 페이지</h3>
    <router-view></router-view>
    <hr />
  </div>
</template>

<script>
export default {
  name: "MyPageView",
  components: {},
};
</script>

<style scoped>
.app_title {
  font-size: 36px;
  /* padding-left: 20px; */
}

.view-content {
  width: 1200px;
  margin: 0 auto;
  margin-top: 0px;
}
</style>
