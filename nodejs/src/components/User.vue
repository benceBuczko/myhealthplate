<template>
  <div class="container"> 
     <div class="row"> 
         <div class="col">
            <b-card :title=name
                tag="article"
                style="max-width: 20rem;"
                class="mb-2">
                <div class="row">
                    <div class="col">
                        <ul>
                            <li>Email:</li>
                            <li>Username:</li>
                            <hr class="featurett-divider">
                            <li>Age:</li>
                            <li>Gender:</li>
                        </ul>
                    </div>
                    <div class="col">
                        <ul>
                            <li class="text-center">N/A</li>
                            <li class="text-center">{{name}}</li>
                            <hr class="featurett-divider">
                            <li class="text-center">N/A</li>
                            <li class="text-center">N/A</li>
                        </ul>
                    </div>
                </div>
            </b-card>
         </div>
         <div class="col text-center">
            <img class="rounded-circle" src="https://jazwings.com/assets/jpg/placeholders/ProfilePicPlaceholder.jpg" height="300" width="300"><br>
            <b-button class="btn btn-info upload">Upload picture</b-button>
         </div>
     </div>
      
        <b-card no-body>
            <b-tabs pills card vertical>
                <b-tab title="Personal info" active>
                    Personal info
                </b-tab>
                <b-tab title="My Plans">
                    My Plans
                </b-tab>
                <b-tab title="Progress">
                    Progress
                </b-tab>
            </b-tabs>
        </b-card>
    
    </div>
</template>

<script>

export default {
  name: 'User',
  components: {},
  data () {
    return {
        name : this.$session.get('user'),
    }
  },
  created (){
    console.log("cucc")
    if(!this.$session.exists()) this.$router.push("/")
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
</style>
