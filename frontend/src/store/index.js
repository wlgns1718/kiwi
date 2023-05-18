import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

import userStore from "@/store/modules/userStore";
import tourStore from "@/store/modules/tourStore";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: { userStore, tourStore },

  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});
