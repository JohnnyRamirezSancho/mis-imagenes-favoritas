import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import { useAuthStore } from "../stores/authStorage";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/gallery',
      name: 'gallery',
      component: () => import('../views/Gallery.vue')
    },
    {
      path: "/login",
      name: "login",
      component: () => import("../views/Login.vue"),
    },
    {
      path: "/listitemgallery",
      name: "listitemgallery",
      component: () => import("../views/admin/ListItemsGallery.vue"),
      meta: { requiresAuth: true },
    },
    {
      path: "/additemgallery",
      name: "additemgallery",
      component: () => import("../views/admin/AddItemGallery.vue"),
      meta: { requiresAuth: true },
    },
    {
      path: "/imagegallery/:id",
      name: "imagegallery",
      props: true,
      component: () => import("../views/admin/ImageGallery.vue"),
      meta: { requiresAuth: true },
    },
    {
      path: "/edititemgallery/:id",
      name: "edititemgallery",
      props: true,
      component: () => import("../views/admin/EditItemGallery.vue"),
      meta: { requiresAuth: true },
    }
  ]
})

router.beforeEach(async (to, from) => {
  const auth = useAuthStore();
  if (to.meta.requiresAuth && !auth.isAuthenticate) {
    return { name: "home" };
  }
});

export default router