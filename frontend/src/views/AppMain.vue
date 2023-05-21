<template>
  <div class="main-content">
    <main-image-swiper></main-image-swiper>
  </div>
</template>

<script>
import MainImageSwiper from "@/components/main/MainImageSwiper.vue";
import { mapActions } from "vuex";

export default {
  name: "AppMain",
  components: {
    MainImageSwiper,
  },
  created() {
    this.navToggle(this.$route.path);
  },
  methods: {
    ...mapActions("headerStore", ["navToggle"]),
  },
};
</script>

<style scope>
.main-content {
  width: 1200px;
  margin: 0 auto;
  margin-top: 50px;
}
</style>
