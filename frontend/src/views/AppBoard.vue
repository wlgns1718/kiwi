<template>
  <div class="view-content">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "BoardView",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
/* .app_title {
  position: fixed;
} */
</style>
