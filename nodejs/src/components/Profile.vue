<template>
  <div id="content">
            <button type="button" @click="toogle" id="sidebarCollapse" class="btn btn-info navbar-btn">
                <span></span>
                <span></span>
                <span></span>
            </button>
            <div class="container"> 
                <div class="row"> 
                    <div class="col-lg-4">
                        <b-card header="Your profile"
                            header-text-variant="white"
                            header-tag="header"
                            header-bg-variant="info"
                            tag="article"
                            style="max-width: 20rem;"
                            class="mb-2">
                            <div class="row">
                                <div class="col">
                                    <ul>
                                        <li>Email:</li>
                                        <li>Username:</li>
                                        <hr class="featurett-divider">
                                        <li>Daily Energy Intake:</li>
                                    </ul>
                                </div>
                                <div class="col">
                                    <ul>
                                        <li class="text-center">{{email}}</li>
                                        <li class="text-center">{{name}}</li>
                                        <hr class="featurett-divider">
                                        <li class="text-center">{{energy}}</li>
                                    </ul>
                                </div>
                            </div>
                        </b-card>
                    </div>
                    <div class="col-lg-8">
                        <b-table stacked :items="items"></b-table>
                    </div>
                </div> 
                <div class="row">
                    <div class="col">
                        <p v-if="this.$session.get('user').age == 0">
                            We are still missing some of the information above to determine your Daily Energy Intake. <br>
                            Please fill all the necessary information, so we can help you track how much you should eat a usual day!
                        </p>
                        <b-btn v-b-toggle.collapse1 variant="info"><i class="material-icons">ballot</i>Modify profile data</b-btn>
                    </div>
                </div> 
                    <div class="row lastrow">
                        <div class="col-lg-6">
                            <b-collapse id="collapse1" class="mt-2">
                                <b-form @submit="onSubmit">
                                    <b-form-group id="gender"
                                                    label="Gender"
                                                    label-for="radios1"
                                                    description="Select your gender!">
                                        <b-form-radio-group id="radios1" 
                                                            v-model="form.gender" 
                                                            :options="options" 
                                                            required
                                                            name="radioOptions">
                                        </b-form-radio-group>
                                    </b-form-group>
                                    <b-form-group id="age"
                                                    label="Age:"
                                                    label-for="exampleInput2">
                                        <b-form-input id="exampleInput2"
                                                    type="number"
                                                    v-model="form.age"
                                                    required
                                                    min='18'
                                                    max='100'
                                                    placeholder="Age">
                                        </b-form-input>
                                    </b-form-group>
                                    <b-form-group id="height"
                                                    label="Height(cm):"
                                                    label-for="exampleInput2">
                                        <b-form-input id="exampleInput2"
                                                    type="number"
                                                    v-model="form.height"
                                                    required
                                                    min='130'
                                                    max='250'
                                                    placeholder="Height">
                                        </b-form-input>
                                    </b-form-group>
                                    <b-form-group id="weight"
                                                    label="Weight(kg):"
                                                    label-for="exampleInput2">
                                        <b-form-input id="exampleInput2"
                                                    type="number"
                                                    v-model="form.weight"
                                                    required
                                                    min='40'
                                                    max='300'
                                                    placeholder="Weight">
                                        </b-form-input>
                                    </b-form-group>
                                    <b-form-group id="exampleInputGroup3"
                                                    label="Activity:"
                                                    label-for="exampleInput3">
                                        <b-form-select id="exampleInput3"
                                                    :options="activities"
                                                    required
                                                    v-model="form.activity">
                                                    <template slot="first">
                                                        <option :value="null" disabled>-- Please select an option --</option>
                                                    </template>
                                        </b-form-select>
                                    </b-form-group>
                                    <b-button type="submit" variant="info">Submit</b-button>
                                </b-form>
                            </b-collapse>
                        </div>
                        <div class="col-lg-6 text-center">
                            <img src="http://cdn1.sph.harvard.edu/wp-content/uploads/sites/30/2012/10/plate_questionmark.jpg" >
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
    ageState () {
      return this.age > 2 ? true : false
    }
  },
  data () {
    return {
        name : this.$session.get('user').userName,
        email:  this.$session.get('user').email,
        energy: parseFloat(Math.round(this.$session.get('user').energy * 100) / 100).toFixed(2),
        items: [
            this.setUserData(),
        ],
        options: [
            { text: 'Male', value: true },
            { text: 'Female', value: false },
        ],
        activities: [
            { text: 'Light', value: 1 },
            { text: 'Medium', value: 2 },
            { text: 'Hard', value: 3 },
            { text: 'Extrem Hard', value: 4 },
        ],
        form: {
            gender: null,
            activity: null,
            age: null,
            height: null,
            weight: null
        }
    }
  },
  created (){
    $('li').removeClass("active");
    $('#profile').toggleClass("active");
    if(!this.$session.exists()) this.$router.push("/")
  },
  methods:{
      toogle(){
          $('#sidebar').toggleClass('active');
          $('#sidebarCollapse').toggleClass('active');
      },
      setUserData(){
          var activity;
          switch(this.$session.get('user').activity){
                case 1: activity = "Light"
                        break;
                case 2: activity = "Medium"
                        break;
                case 3: activity = "Hard";
                        break;
                case 4: activity = "Extreme Hard";
                        break;
          }

          if (this.$session.get('user').age > 0){
              return { gender: this.$session.get('user').gender ? "Male" : "Female", age: this.$session.get('user').age + " years old", height: this.$session.get('user').height + " cm", weight: this.$session.get('user').weight+ " kg", activity: activity};
          } else {
              return { gender: '-', age: '-', height: '-', weight: '-', activity: '-'};
          }
      },
      onSubmit(e){
            e.preventDefault();
            var self = this;
            var formdata = new FormData();
            formdata.append("email", this.email)
            formdata.append("gender", this.form.gender)
            formdata.append("activity", this.form.activity)
            formdata.append("age", this.form.age)
            formdata.append("height", this.form.height)
            formdata.append("weight", this.form.weight)
            axios.post('http://localhost:9999/user/update', formdata)
            .then(function (response) {
                if(response.data !== false){
                self.$session.set('user', response.data)
                location.reload();
                } else {
                console.log(response)
                self.showpopover = true;
                setTimeout(function(){
                self.showpopover = false},3000);
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
