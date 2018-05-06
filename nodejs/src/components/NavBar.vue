<!--Navbar.vue-->
<template>
<b-navbar toggleable="md" type="dark" variant="dark">

  <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

  <b-navbar-brand href="/">
      <img src="https://students.usask.ca/images/icons/healthy-vegetarian-eating.png" width="30" height="30" class="d-inline-block align-top" alt=""/>
        <strong>My Health Plate</strong>
    </b-navbar-brand>

  <b-collapse is-nav id="nav_collapse">
    <!-- Right aligned nav items -->
    <b-navbar-nav class="ml-auto">
      

        <b-nav-form id="loginForm" v-on:submit.prevent="onSubmit" v-if="!this.$session.exists()">
            <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Username" name="username" id="username"/>
            <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Password" name="password" id="password"/>
            <b-button size="sm" class="my-2 my-sm-0 btn-info" type="button" @click="performPostRequest">Sign In</b-button>
        </b-nav-form>
        <b-navbar-nav>
          <b-nav-item href=# v-if="this.$session.exists()">Welcome {{this.$session.get('user')}} </b-nav-item>
          <b-nav-item @click="logout" v-if="this.$session.exists()">Logout</b-nav-item>
        </b-navbar-nav> 


    </b-navbar-nav>

  </b-collapse>
</b-navbar>
</template>

<script>
import axios from 'axios';
import $ from 'jquery';

export default {
  name: 'NavBar',
  data () {
    return {
    }
  },
  methods: {
    performPostRequest() {
      var formdata = new FormData();
      var username = $('#username').val();
      var password = $('#password').val();
      
      var self = this;

      formdata.append("email", username);
      formdata.append("password", password);
      axios.post('http://127.0.0.1:9999/login', 
        formdata
        )
      .then(function (response) {
        if(response.data !== false){
          self.$session.start()
          self.$session.set('user', response.data)
          location.reload();
        } else {
          console.log("shit")
        };
      })
      .catch(function (error) {
        console.log(error);
      });
    },
    logout() {
      this.$session.destroy();
      location.reload();
    }
  }
}

$(document).ready(function () {
  $('#loginForm').submit(function(e){
    e.preventDefault();
    performPostRequest();
  });
})

</script>


<style scoped>

</style>