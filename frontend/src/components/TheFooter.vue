<template>
  <div class="footerWrap">
    <div>CopyRight @ 2023. YoonWooHyuk, ShinJiHoon All rights reserved</div>
    <div>Contact With (wlgns1718@naver.com / yoon@naver.com)</div>
  </div>
</template>

<script>
export default {
  name: "TheFooterView",
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
.footerWrap {
  min-height: 50px;
  width: 100%;
  position: absolute;
  bottom: 0;
  background-color: #000000;
  color: white;
  font-weight: bold;
  font-size: 10pt;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
}
</style>