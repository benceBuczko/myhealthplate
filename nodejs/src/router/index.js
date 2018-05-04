import Vue from 'vue'
import Router from 'vue-router'
import IndexContainer from '@/components/IndexContainer'

Vue.use(Router)


export default new Router({
  routes: [
    {
      path: '/',
      name: 'IndexContainer',
      component: IndexContainer
    }
  ]
})
