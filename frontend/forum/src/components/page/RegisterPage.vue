<template>
    <h2>Register</h2>
    <form>
        <div class="third">
            <input class="stack" type="login" placeholder="Login" v-model="creds.login" />
            <input class="stack" type="text" placeholder="Email" v-model="creds.email" />
            <input class="stack" type="password" placeholder="Password" v-model="creds.password" />
            <button class="stack icon-paper-plane" v-on:click="register(creds.login, creds.password, creds.email)">
                Register
            </button>
        </div>
    </form>
</template>

<script>
import axios from "axios"

export default {
    data() {
        return {
            creds: {
                login: "",
                email: "",
                password: ""
            }
        }
    },
    methods: {
        register(login, password, email) {
            axios.post("http://localhost:8081/api/user/register", { login, password, email })
                .then(response => alert(response.data))
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