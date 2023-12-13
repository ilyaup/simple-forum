<template>
  <div>
    <HeaderView />
    <MiddleView :posts="posts" :users="users" />
  </div>
</template>

<script>
import MiddleView from "./components/MiddleView.vue"
import HeaderView from "./components/HeaderView.vue"
import axios from "axios"

export default {
  name: 'App',
  components: {
    MiddleView,
    HeaderView
  },
  data: function () {
    return {
      user: null,
      posts: [],
      users: []
    }
  },
  beforeMount() {
    axios.get("http://localhost:8081/api/post/posts").then(response => {
      this.posts = response.data;
    });
    axios.get("http://localhost:8081/api/user/users").then(response => {
      this.users = response.data;
    });
  },
  beforeCreate() {
    this.$root.$on("onRegister", (login, password, email) =>
      axios.post("http://localhost:8081/api/user/register", { login, password, email })
        .then(response => alert(response.data)))
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
