<template>
    <v-footer class="pa-3">
        <v-spacer></v-spacer>
        <div id="footer">
            <p class="float-right"><a href="#"  v-scroll-to="'#navbar'"><i class="material-icons">arrow_upward</i></a></p>
            <p class="float-left text-white">© 2017-2018 Company-B, Inc.</p>
        </div>
    </v-footer>
</template>
<script>
export default {
  name: 'Footer',
  data () {
    return {
    }
  }
}
</script>


<style scoped>
.footer{
    height: 76px!important;
    background-color: #343a40;
}
.float-right{
        margin-right: 2rem;
}
.float-left{
    margin-left: 2rem;
}
</style>