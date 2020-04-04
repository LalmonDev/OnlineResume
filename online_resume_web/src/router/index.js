import Vue from 'vue'
import Router from 'vue-router'

import iView from 'iview'
import login from '@/views/login'
import sucess from '@/views/sucess'
import register from '@/views/register'
import forgetpasswd from '@/views/forgetpasswd'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/sucess',
      name: 'sucess',
      component: sucess
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
