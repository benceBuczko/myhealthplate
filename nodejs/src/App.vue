<template>
  <div id="app">
    <NavBar/>
    <router-view/>
    <Footer/>
  </div>
</template>

<script>

import NavBar from '@/components/NavBar'
import Footer from '@/components/Footer'

export default {
  name: 'App',
  components: {NavBar, Footer}
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
