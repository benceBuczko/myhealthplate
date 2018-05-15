<template>
  <v-layout row wrap class="firstrow">
        <v-flex xs12 align-content-center>
            <h2 class="text-center w3-tangerine mainText">Awesome About page!<br/><br/>
            Under development...</h2><br/>
        </v-flex>
    </v-layout>
</template>

<script>

export default {
  name: 'About',
  components: {},
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