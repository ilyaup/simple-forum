<template>
    <form @submit.prevent="onRegister">
        <div class="field">
            <div class="name">
                <label for="login">Login</label>
            </div>
            <div class="value">
                <input autofocus id="login" name="login" v-model="login" />
            </div>
        </div>
        <div class="field">
            <div class="name">
                <label for="password">Password</label>
            </div>
            <div class="value">
                <input id="password" name="password" type="password" v-model="password" />
            </div>
        </div>
        <div class="field">
            <div class="name">
                <label for="email">Email</label>
            </div>
            <div class="value">
                <input autofocus id="email" name="email" v-model="email" />
            </div>
        </div>
        <div class="button-field">
            <input type="submit" value="Register">
        </div>
    </form>
</template>

<script>
export default {
    name: 'RegisterPage',
    data: function () {
        return {
            login: "",
            password: "",
            email: ""
        }
    },
    methods: {
        onRegister: function () {
            this.$root.$emit("onRegister", this.login, this.password, this.email)
        }
    }
}
</script>