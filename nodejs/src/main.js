// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'jquery/dist/jquery.min.js'
import VeeValidate from 'vee-validate'
import VueSession from 'vue-session'
import Vuetify from 'vuetify'
import VueScrollTo from 'vue-scrollto'
import * as VueGoogleMaps from "vue2-google-maps";

Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyCl84y5rPhifwaZ3sH3a3k5hpGMzdwJIBk",
    libraries: "places" // necessary for places input
  }
});

Vue.use(VueScrollTo)

Vue.use(Vuetify)

Vue.use(VueSession)

Vue.use(VeeValidate);

Vue.use(BootstrapVue);

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
