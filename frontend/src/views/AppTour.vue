<template>
  <div class="tour-content">
    <h3 class="app_title">관광지 명소</h3>
    <div class="tour-wrap">
      <div>
        <tour-search-bar></tour-search-bar>
      </div>
      <div class="tour-map-result-wrap">
        <div class="left">
          <tour-map></tour-map>
        </div>
        <div class="right">
          <tour-result></tour-result>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TourMap from "@/components/tour/TourMap.vue";
import TourSearchBar from "@/components/tour/TourSearchBar.vue";
import TourResult from "@/components/tour/TourResult.vue";

export default {
  name: "AppTour",
  components: { TourMap, TourSearchBar, TourResult },
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

.tour-wrap {
  height: 100%;
}

.tour-map-result-wrap {
  display: flex;
  justify-content: space-between;
}
</style>
