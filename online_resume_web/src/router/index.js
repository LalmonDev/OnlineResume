import Vue from 'vue'
import Router from 'vue-router'

import iView from 'iview'
import login from '@/views/login'
import register from '@/views/register'
import forgetpasswd from '@/views/forgetpasswd'
import user_index from '@/views/user_index'
import newResume from '@/views/newResume'
import showResume from '@/views/showResume'
import userInfo from '@/views/userInfo'
import passwdReset from '@/views/passwdReset'
import manage from '@/views/manage'
import manageUser from '@/views/manageUser'

import welcome from '@/views/welcome'

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
      component: user_index,
      children:[
        {
          path: '/',
          name: 'welcome',
          component: welcome
        },
        {
          path: '/userInfo',
          name: 'userInfo',
          component: userInfo
        },
        {
          path: '/newResume',
          name: 'newResume',
          component: newResume
        },
        {
          path: '/showResume',
          name: 'showResume',
          component: showResume
        }
      ]
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
    },
    {
      path: '/passwdReset',
      name: 'passwdReset',
      component: passwdReset
    },
    {
      path: '/manage',
      name: 'manage',
      component: manage,
      children:[
        {
          path: '/',
          name: 'manageUser',
          component: manageUser
        },
      ]
    },
  ]
})
