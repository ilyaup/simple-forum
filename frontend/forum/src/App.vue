<template>
  <div id="app">
    <HeaderComponent />
    <br>
    <h1>Forum</h1>
    <router-view></router-view>
  </div>
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue';
import { ref, provide } from "vue"
// import axios from 'axios';

export default {
  name: 'App',
  components: {
    HeaderComponent
  },
  setup() {
    // const jwt = localStorage.getItem("jwt")
    // if (jwt) {
    //   axios.get("http://localhost:8081/api/user/auth", {
    //     params: {
    //       jwt: this.jwt
    //     }
    //   })
    //     .then(response => {
    //       provide('logged_user', ref(response.data))
    //     })
    // } else {
    //   provide('logged_user', ref(null))
    // }
    const local_logged_user = localStorage.getItem("logged_user")
    if (local_logged_user) {
      provide('logged_user', ref(JSON.parse(local_logged_user)))
    } else {
      provide('logged_user', ref(null))
    }
  }
}
</script>
