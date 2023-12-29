<script>
import { inject, ref } from 'vue'

export default {
    name: 'HeaderComponent',
    setup() {
        const user = inject('logged_user', ref(null))
        return {
            user
        }
    },
    methods: {
        logout() {
            localStorage.removeItem("jwt")
            localStorage.removeItem("logged_user")
            this.user = null
        }
    }
}
</script>

<template>
    <nav>
        <router-link class="button" to="/">Home</router-link>
        <router-link class="button" to="/users">Users</router-link>
        <router-link class="button" to="/post">Write post</router-link>
        <router-link class="button" to="/info">Info</router-link>
        <span class="auth">
            <span v-if="user">
                {{ user.login }}
                <span tag="router-link" class="button" v-on:click="logout()">Log out</span>
            </span>
            <span v-else>
                <router-link class="button" to="/login">Log in</router-link>
                <router-link class="button" to="/register">Register</router-link>
            </span>
        </span>
    </nav>
</template>

<style scoped>
.button {
    margin: 3px;
}

.auth {
    float: right;
}

.auth .button {
    background: #85144b;
}
</style>