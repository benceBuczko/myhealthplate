<template>
    <v-container fluid text-xs-center>
        <v-layout  row>
            <v-flex d-flex xs2>
                <v-navigation-drawer id="sidebar" permanent light>
                    <v-list>
                        <v-list-tile key="l1" @click="home">
                            <v-list-tile-action>
                            <v-icon>home</v-icon>
                            </v-list-tile-action>
                            <v-list-tile-content>
                            <v-list-tile-title>Home</v-list-tile-title>
                            </v-list-tile-content>
                        </v-list-tile>
                        <v-list-tile key="l1" @click="about">
                            <v-list-tile-action>
                            <v-icon>subject</v-icon>
                            </v-list-tile-action>
                            <v-list-tile-content>
                            <v-list-tile-title>About</v-list-tile-title>
                            </v-list-tile-content>
                        </v-list-tile>
                        <v-list-tile key="l2" @click="browse">
                            <v-list-tile-action>
                            <v-icon>search</v-icon>
                            </v-list-tile-action>
                            <v-list-tile-content>
                            <v-list-tile-title>Browse</v-list-tile-title>
                            </v-list-tile-content>
                        </v-list-tile>
                        <v-list-tile key="l3" @click="contact">
                            <v-list-tile-action>
                            <v-icon>email</v-icon>
                            </v-list-tile-action>
                            <v-list-tile-content>
                            <v-list-tile-title>Contact</v-list-tile-title>
                            </v-list-tile-content>
                        </v-list-tile>
                    </v-list>
                </v-navigation-drawer>
            </v-flex>
            <v-flex xs10>
                <transition name="fade">
                    <Home v-show="content === 'home'"/>
                </transition>
                <transition name="fade">
                    <About v-show="content === 'about'"/>
                </transition>
                <transition name="fade">
                    <Contact v-show="content === 'contact'"/>
                </transition>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import Home from '@/components/Home'
import About from '@/components/About'
import Contact from '@/components/Contact'

export default {
  name: 'IndexContainer',
  components: {Home, About, Contact},
  data () {
    return {
        content : "home",
    }
  },
  methods: {
    about(){
        var self = this
        if (self.content !== 'about'){
            this.content = ""
            setTimeout(function(){self.content = "about"}, 501)
        }
    },
    home(){
        var self = this
        if (self.content !== 'home'){
            this.content = ""
            setTimeout(function(){self.content = "home"}, 501)
        }
    },
    browse(){
        var self = this
        if (self.content !== 'browse'){
            this.content = ""
            setTimeout(function(){self.content = "browse"}, 501)
        }
    },
    contact(){
        var self = this
        if (self.content !== 'contact'){
            this.content = ""
            setTimeout(function(){self.content = "contact"}, 501)
        }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
.container {
   padding: 0!important;
   margin-left: 10px;
}
.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}

</style>
