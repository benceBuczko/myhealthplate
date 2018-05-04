<template>
  <div class="container">
        <div class="row firstrow">
            <div class="col-lg-6 text-center">
                <img src="http://www.receptdoki.hu/images/cikk_okostanyer.jpg" height="90%" width="90%" />
            </div>
            <div class="col-lg-6 text-center">
                <h2 class="text-center w3-tangerine mainText">Keeping up with a healthy diet is a long-term commitment, but it is within your reach. <br/><br/>
                Register to get started!</h2><br/>
                <b-btn class="btn btn-info text-center registerButton" v-b-modal.modalRegister>Register</b-btn>
            </div>
        </div>
        <Register/>
    </div>
</template>

<script>
import Register from '@/components/Register'

export default {
  name: 'IndexContainer',
  components: {Register},
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.firstrow{
    margin-top: 10%;
}

.registerButton{
    padding-left: 8%;
    padding-right: 8%;
    border-radius: 45%;
}

.w3-tangerine {
    font-family: 'Tangerine', serif;
}

.container{
    width: 80%;
}

.mainText{
    margin-top: 5%;
}
</style>
