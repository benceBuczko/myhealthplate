<template>
<div class="wrapper">
    <!-- Sidebar -->
        <nav id="sidebar">
            <!-- Sidebar Header -->
            <div class="sidebar-header">
                <h3>{{name}}</h3>
            </div>

            <!-- Sidebar Links -->
            <ul class="list-unstyled components">
                <li id="profile" class="active"><a href="/#/user/profile">Personal Info</a></li>
                <li id="plans"><a href="/#/user/plans">My Plans</a></li>
                <li id="recipes"><a href="/#/user/recipes">My Recipes</a></li>
                <li id="progress"><a href="/#/user/progress">Progress</a></li>
            </ul>
        </nav>

    <!-- Page Content -->
        <router-view></router-view>
</div>     
</template>

<script>
import $ from'jquery'
import axios from 'axios';

export default {
  name: 'User',
  components: {},
  data () {
    return {
        name : this.$session.get('user').userName,
    }
  },
  created (){
    if(!this.$session.exists()) this.$router.push("/")
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.wrapper {
    display: flex;
    align-items: stretch;
}

#sidebar {
    min-width: 250px;
    max-width: 250px;
    min-height: 100vh;
}

#sidebar.active {
    margin-left: -250px;
}

a[data-toggle="collapse"] {
    position: relative;
}

a[aria-expanded="false"]::before, a[aria-expanded="true"]::before {
    content: '\e259';
    display: block;
    position: absolute;
    right: 20px;
    font-family: 'Glyphicons Halflings';
    font-size: 0.6em;
}

a[aria-expanded="true"]::before {
    content: '\e260';
}
@media (max-width: 768px) {
    #sidebar {
        margin-left: -250px;
    }
    #sidebar.active {
        margin-left: 0;
    }
}


@import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";


body {
    font-family: 'Poppins', sans-serif;
    background: #fafafa;
}

#content{
    width: 100%;
}

p {
    font-family: 'Poppins', sans-serif;
    font-size: 1.1em;
    font-weight: 300;
    line-height: 1.7em;
    color: #999;
}

a, a:hover, a:focus {
    color: inherit;
    text-decoration: none;
    transition: all 0.3s;
}

#sidebar {
    /* don't forget to add all the previously mentioned styles here too */
    background: #17a2b8;
    color: #fff;
    transition: all 0.3s;
}

#sidebar .sidebar-header {
    padding: 20px;
    background: #158799;
}

#sidebar ul.components {
    padding: 20px 0;
}

#sidebar ul p {
    color: #fff;
    padding: 10px;
}

#sidebar ul li a {
    padding: 10px;
    font-size: 1.1em;
    display: block;
}
#sidebar ul li a:hover {
    color: #158799;
    background: #fff;
}

#sidebar ul li.active > a, a[aria-expanded="true"] {
    color: #fff;
    background: #158799;
}
ul ul a {
    font-size: 0.9em !important;
    padding-left: 30px !important;
    background: #158799;
}
</style>
