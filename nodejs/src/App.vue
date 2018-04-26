<template>
  <div id="app">
    <NavBar/>
    <IndexContainer/>
    <Footer/>
  </div>
</template>

<script>
import IndexContainer from './components/IndexContainer'
import NavBar from './components/NavBar'
import Footer from './components/Footer'

export default {
  name: 'App',
  components: {
    NavBar,
    IndexContainer,
    Footer
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
