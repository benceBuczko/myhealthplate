<template>
  <div id="content">
            <button type="button" @click="toogle" id="sidebarCollapse" class="btn btn-info navbar-btn">
                <span></span>
                <span></span>
                <span></span>
            </button>
            <div class="container"> 
                <div class="row"> 
                    <div class="col">
                        <b-button class="btn btn-outline-info">+ Add new Recipe </b-button>
                        <hr class="my-4">
                    </div>
                </div>
                <div class="row lastrow">
                    <div class="col">
                        <b-card-group deck>
                            <div v-for="recipe in recipes">
                                <b-card :title="recipe.name"
                                        :img-src="recipe.picture"
                                        img-alt="Image"
                                        img-top
                                        tag="article"
                                        style="max-width: 20rem;"
                                        class="mb-2">
                                    <p class="card-text">
                                    {{recipe.description}}
                                    </p>
                                    <b-button href="#" variant="info">Check it out</b-button>
                                </b-card>
                            </div>
                        </b-card-group>
                    </div>
                </div>    
            </div>
    </div>
</template>

<script>
import $ from'jquery'
import axios from 'axios';

export default {
  name: 'User',
  components: {},
  computed: {
  },
  data () {
    return {
        name : this.$session.get('user').userName,
        recipes: []

    }
  },
  mounted (){
    if(!this.$session.exists()) this.$router.push("/");
    $('li').removeClass("active");
    $('#recipes').toggleClass("active");
    var self = this;
    var userid = this.$session.get('user').id;
    axios.get('http://localhost:9999/get-recipes/'+ userid)
      .then(function (response) {
          self.recipes = response.data;
      })
      .catch(function (error) {
        console.log(error);
      });

  },
  methods:{
      toogle(){
          $('#sidebar').toggleClass('active');
          $('#sidebarCollapse').toggleClass('active');
      }
  }
}
</script>
<style scoped>
.btn-outline-info{
    margin-left: 70px;
}
.lastrow{
    margin-bottom: 100px;
}

table {
    margin-top: 70px;
}

h1 {
    margin-top: 100px;
    margin-left: 70px;
}
.card{
    margin-top: 50px;
    margin-bottom: 50px;
}
ul {
  list-style-type: none;
}

.wrapper {
    display: flex;
    align-items: stretch;
}
#sidebarCollapse {
    width: 40px;
    height: 40px;
    background-color: #158799;
    border-radius: 0;
    border: 0;
}

#sidebarCollapse span {
    width: 80%;
    height: 2px;
    margin: 0 auto;
    display: block;
    background:white;
    transition: all 0.8s cubic-bezier(0.810, -0.330, 0.345, 1.375);
}
#sidebarCollapse span:first-of-type {
    /* rotate first one */
    transform: rotate(45deg) translate(2px, 2px);
}
#sidebarCollapse span:nth-of-type(2) {
    /* second one is not visible */
    opacity: 0;
}
#sidebarCollapse span:last-of-type {
    /* rotate third one */
    transform: rotate(-45deg) translate(1px, -1px);
}
#sidebarCollapse.active span {
    /* no rotation */
    transform: none;
    /* all bars are visible */
    opacity: 1;
    margin: 5px auto;
}
</style>
