<script>
import UserComponent from "../UserComponent.vue"
import jsonUsers from "../../../assets/users.json"
import axios from 'axios'

export default {
    components: {
        UserComponent
    },
    data() {
        return {
            users: jsonUsers
        }
    },
    mounted() {
        axios.get("http://localhost:8081/api/user/users").then(response => {
            this.users = response.data;
        });
    }
}
</script>

<template>
    <h2>Users</h2>
    <table class="users">
        <thead>
            <tr>
                <th>Login</th>
                <th>Email</th>
                <th>Rating</th>
            </tr>
        </thead>
        <tbody>
            <UserComponent v-for="user in users" :user="user" :key="user.login" />
        </tbody>
    </table>
</template>