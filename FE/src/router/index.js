import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import AboutView from "@/components/AboutView.vue";
import LoginView from "@/components/userAction/userLoginView.vue";

import store from "@/store";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    component: AboutView,
    beforeEnter: (to, from, next) => {
      const isLogin = store.getters["loginStore/isLogin"];
      if (!isLogin) {
        next("/login?returnUrl=" + to.fullPath);
      } else {
        next();
      }
    },
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
  },
  // {
  // path: "/register",
  // name: "register",
  // component: RegisterView,
  // },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
