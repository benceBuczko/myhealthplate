import Vue from 'vue'
import Router from 'vue-router'
import IndexContainer from '@/components/IndexContainer'
import Registry from '@/components/Registry'
import User from '@/components/User'

Vue.use(Router)


export default new Router({
  routes: [
    {
      path: '/',
      name: 'IndexContainer',
      component: IndexContainer
    },
    {
      path: '/registry',
      name: 'Registry',
      component: Registry
    },
    {
      path: '/user',
      name: 'User',
      component: User
    }

  ]
})
