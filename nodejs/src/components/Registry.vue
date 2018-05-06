<template>
  <div class="container">
        <div class="row firstrow">
            <div class="col">
                <h2 class="text-center w3-tangerine mainText">Thank you for registering to our site! <br/><br/>
                Please log in with your credentials in the top rigth corner! </h2><br/>
            </div>
        </div>
        <div class="row">
            <div class="col text-align-center">
                <img src="https://ih1.redbubble.net/image.316926441.0739/flat,1000x1000,075,f.u1.jpg" width="50%" height="70%">
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Registry',
  components: {

  },
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

.registerButton{
    padding-left: 8%;
    padding-right: 8%;
    border-radius: 45%;
}

.w3-tangerine {
    font-family: 'Tangerine', serif;
    font-size: 300%;
}

.container{
    width: 80%;
}
.text-align-center{
    text-align: center;
}
.mainText{
    margin-top: 5%;
}
</style>
