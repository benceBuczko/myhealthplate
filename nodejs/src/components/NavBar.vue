<!--Navbar.vue-->
<template>
<b-navbar toggleable="md" type="dark" variant="dark">

  <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

  <b-navbar-brand href="#">
      <img src="https://students.usask.ca/images/icons/healthy-vegetarian-eating.png" width="30" height="30" class="d-inline-block align-top" alt=""/>
        <strong>My Health Plate</strong>
    </b-navbar-brand>

  <b-collapse is-nav id="nav_collapse">
    <!-- Right aligned nav items -->
    <b-navbar-nav class="ml-auto">
        <b-nav-item href="#">About</b-nav-item>
        <b-nav-item href="#">Contact</b-nav-item>

        <b-nav-form id="loginForm">
            <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Username" name="username" id="username"/>
            <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Password" name="password" id="password"/>
            <b-button size="sm" class="my-2 my-sm-0 btn-info" type="submit">Sign In</b-button>
        </b-nav-form>


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
  }
}

$(document).ready(function () {
  $('#loginForm').submit(function(e){
    e.preventDefault();
    performPostRequest();
  });
})

function performPostRequest() {

  var formdata = new FormData();
  var username = $('#username').val();
  var password = $('#password').val();
  
  formdata.append("username", username);
  formdata.append("password", password);
  axios.post('http://127.0.0.1:9999/', 
    formdata
    )
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
}
</script>


<style scoped>

</style>