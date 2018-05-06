<template>
    <b-modal id="modalRegister" title="Register Form" header-text-variant="light" header-bg-variant="info" ok-title="Register" ok-only ok-variant="info" @ok="handleOk" :ok-disabled="errors.any() || name === ''"
             @shown="clear">
        <p class="warning" id="registerWarning">{{warning}}</p>
            <form  v-on:submit.prevent="onSubmit" ref="regForm">
                <b-form-group label-text-align="left"
                                label="Email address:"
                                label-for="exampleInput1"
                                description="We'll never share your email with anyone else.">
                    <b-form-input id="exampleInput1"
                                type="email"
                                placeholder="Enter email"
                                v-model="email"
                                name="email"
                                v-validate="'required|email'" 
                                v-bind:class="{'form-control': true, 'error': errors.has('email') }">
                    </b-form-input>
                    <span v-show="errors.has('email')" class="text-danger">{{ errors.first('email') }}</span>
                </b-form-group>
                <b-form-group label="Your Name:"
                                label-for="exampleInput2"
                                label-text-align="left"
                                description="How should we call you?"
                                >
                    <b-form-input id="exampleInput2"
                                type="text"
                                placeholder="Enter name"
                                v-model="name"
                                name="name"
                                v-validate="'required'"
                                v-bind:class="{'form-control': true, 'error': errors.has('name') }">
                    </b-form-input>
                    <span v-show="errors.has('name')" class="text-danger">{{ errors.first('name') }}</span>

                </b-form-group>
            <b-form-group label="Password:"
                                label-for="regPassword"
                                label-text-align="left">
                    <b-form-input id="regPassword"
                                type="password"
                                name="password"
                                placeholder="Choose a password"
                                v-model="password"
                                v-validate="'required'"
                                v-bind:class="{'form-control': true, 'error': errors.has('password') }">
                    </b-form-input>
                    <span v-show="errors.has('password')" class="text-danger">{{ errors.first('password') }}</span>
                </b-form-group>
            <b-form-group label="Password again:"
                                label-for="password2"
                                label-text-align="left">
                    <b-form-input id="password2"
                                type="password"
                                name="password2"
                                placeholder="Confirm password"
                                v-model="password2"
                                v-validate="'required'"
                                v-bind:class="{'form-control': true, 'error': errors.has('password2') }">
                    </b-form-input>
                    <span v-show="errors.has('password2')" class="text-danger">{{ errors.first('password2') }}</span>
                </b-form-group>
            </form>
    </b-modal>
</template>

<script>
import axios from 'axios';
import $ from 'jquery';

export default {
  name: 'Register',
  data () {
    return {
        name : "",
        email: "",
        warning: "",
        password: "",
        password2: ""
    }
  },
  methods: {
    clear() {
      this.name = ''
      this.email = ''
      this.warning = ''
      this.password = ''
      this.password2 = ''
    },
    handleOk (evt) {
      // Prevent modal from closing
      evt.preventDefault()
      if (!this.name || !this.email || !this.password || !this.password2) {
        this.warning = "Please fill all the fields"
      } else if(this.password !== this.password2){
        this.warning = "Passwords do not match"
      } else {
        this.handleSubmit()
      }
    },
    handleSubmit () {
      var formData = new FormData();
      formData.append('name',this.name)
      formData.append('email',this.email)
      formData.append('password',this.password)
      var thisData = this
      axios.post("http://localhost:9999/register",formData)
        .then(function (response) { 
          if(response.data === false){
            thisData.warning = "This email address is already registered!"
          } else {
           location.replace("/#/registry")
          };
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
}
</script>


<style scoped>
p {
    text-align: center;
    color: red
}
.form-control.error {
      border-color: #E84444;
      box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(232,68,68,.6);
    }
</style>