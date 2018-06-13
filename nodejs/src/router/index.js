import Vue from 'vue'
import Router from 'vue-router'
import IndexContainer from '@/components/IndexContainer'
import Registry from '@/components/Registry'
import User from '@/components/User'
import Profile from '@/components/Profile'
import Recipes from '@/components/Recipes'

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
      component: User,
      children: [
        {
          path: 'profile',
          component: Profile
        },
        {
          path: 'recipes',
          component: Recipes
        }
      ]
    }

  ]
})
