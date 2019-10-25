import Vue from 'vue'
import App from './App.vue'
import router from './router'

import { Navbar, Input, Field, Button } from 'buefy'

Vue.config.productionTip = false

Vue.use(Navbar)
Vue.use(Input)
Vue.use(Field)
Vue.use(Button)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
