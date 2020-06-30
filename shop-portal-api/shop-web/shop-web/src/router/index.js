import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import product from '@/components/product/product'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/product',
      name: 'product',
      component: product
    },
  ]
})
