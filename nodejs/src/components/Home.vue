<template>
  <v-layout row wrap class="firstrow">
        <v-flex xs6>
            <img src="http://www.receptdoki.hu/images/cikk_okostanyer.jpg" height="200" width="300" />
        </v-flex>
        <v-flex xs6>
            <h2 class="text-center w3-tangerine mainText">Keeping up with a healthy diet is a long-term commitment, but it is within your reach. <br/><br/>
            Register to get started!</h2><br/>
            <b-btn class="btn btn-info text-center registerButton" v-b-modal.modalRegister>Register</b-btn>
        </v-flex>
        <Register/>
    </v-layout>
</template>

<script>
import Register from '@/components/Register'

export default {
  name: 'Home',
  components: {Register},
  data () {
    return {
    }
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
  font-size: 300%;
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
.firstrow{
    margin-top: 40px;
    border: 2px #00a55b;
}
</style>

