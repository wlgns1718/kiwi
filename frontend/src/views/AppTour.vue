<template>
  <div class="tour-content">
    <h3 class="app_title">관광지 명소</h3>
    <div class="tour-wrap"><tour-map></tour-map></div>
  </div>
</template>

<script>
import TourMap from "@/components/tour/TourMap.vue";

export default {
  name: "AppTour",
  components: { TourMap },
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
.tour-content {
  width: 1200px;
  margin: 0 auto;
  margin-top: 0px;
}
</style>
