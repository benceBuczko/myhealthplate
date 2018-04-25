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

        <b-nav-item-dropdown right>
            <!-- Using button-content slot -->
            <template slot="button-content">
            <em>User</em>
            </template>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Signout</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-form>
            <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Search recipes"/>
            <b-button size="sm" class="my-2 my-sm-0 btn-info" type="submit">Search</b-button>
        </b-nav-form>


    </b-navbar-nav>

  </b-collapse>
</b-navbar>
</template>

<script>
export default {
  name: 'NavBar',
  data () {
    return {
    }
  }
}
</script>


<style scoped>

</style>