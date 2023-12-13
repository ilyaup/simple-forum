<template>
    <nav>
        <ul>
            <li><a href="#" @click.prevent="changePage('IndexView')">Posts</a></li>
            <li><a href="#" @click.prevent="changePage('UsersView')">Users</a></li>
            <li><a href="#" @click.prevent="changePage('RegisterPage')">Register</a></li>
        </ul>
    </nav>
</template>

<script>
export default {
    name: "HeaderView",
    methods: {
        changePage: function (page) {
            this.$root.$emit("onChangePage", page);
        }
    }
}
</script>