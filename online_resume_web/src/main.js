import Vue from 'vue'
import App from './App'
import router from './router'

import VueRouter from 'vue-router'

// 引入axios
// import VueAxios from 'vue-axios'
// import axios from './axios'

// 引入iView
import iView from 'iview'
import 'iview/dist/styles/iview.css'

//引入ElementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// Vue.use(VueAxios,axios)
Vue.use(iView)
Vue.use(ElementUI)

Vue.config.productionTip = false

const axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8081/api';
Vue.prototype.$axios = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
