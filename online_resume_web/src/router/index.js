import Vue from 'vue'
import Router from 'vue-router'

import iView from 'iview'
import login from '@/views/login'
import register from '@/views/register'
import forgetpasswd from '@/views/forgetpasswd'
import user_index from '@/views/user_index'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/user_index',
      name: 'user_index',
      component: user_index
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path: '/forgetpasswd',
      name: 'forgetpasswd',
      component: forgetpasswd
    }
  ]
})
