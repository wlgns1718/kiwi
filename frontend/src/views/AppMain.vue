<template>
  <div class="main-content">
    <main-image-swiper ></main-image-swiper>
  </div>
</template>

<script>
import MainImageSwiper from "@/components/main/MainImageSwiper.vue"

export default {
    name: "AppMain",
    components: {
        MainImageSwiper,
    }
}
</script>

<style scope>
.main-content {
    margin-top: 50px;
}
</style>