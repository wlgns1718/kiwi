import Vue from "vue";
import VueRouter from "vue-router";

//views
import AppMain from "@/views/AppMain.vue";
import AppTour from "@/views/AppTour.vue";
import AppUser from "@/views/AppUser";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/tour",
    name: "tour",
    component: AppTour,
  },
  {
    path: "/user/login",
    name: "user",
    component: AppUser,
  }
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
