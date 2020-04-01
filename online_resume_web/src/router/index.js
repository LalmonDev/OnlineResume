import Vue from 'vue'
import Router from 'vue-router'

import iView from 'iview'
import login from '@/views/login'
import sucess from '@/views/sucess'

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
      components: sucess
    }
  ]
})
