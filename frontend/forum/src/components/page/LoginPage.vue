<template>
    <h2>Log in</h2>
    <form>
        <div class="third">
            <input class="stack" type="login" placeholder="Login" v-model="login" />
            <input class="stack" type="password" placeholder="Password" v-model="password" />
            <button class="stack icon-paper-plane" v-on:click="log_in(login, password)">
                Log in
            </button>
            <span class="errors" v-if="Array.isArray(errors) && errors.length">   
                {{ errors }}
            </span>
        </div>
    </form>
</template>

<script>
import axios from 'axios'
import { inject, ref } from 'vue'

export default {
    data() {
        return {
            login: "",
            password: "",
            jwt: "",
            errors: [],
            user: inject('logged_user', ref(null))
        }
    },
    methods: {
        log_in: function(login, password) {
            axios.post("http://localhost:8081/api/jwt/login", {login, password})
                .then(response => {
                    this.jwt = response.data
                    localStorage.setItem("jwt", this.jwt)
                    axios.get("http://localhost:8081/api/user/auth", {
                        params: {
                            jwt: this.jwt
                        }
                    })
                    .then(response => {
                        localStorage.setItem("logged_user", JSON.stringify(response.data))
                        this.user = response.data
                    })
                })
            this.$router.push('/')
        }
    }
}
</script>

<style scoped>
form {
    height: 200px;
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>