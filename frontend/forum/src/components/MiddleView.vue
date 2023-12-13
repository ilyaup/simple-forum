<template>
    <div>
        {{ page }}
        <IndexView v-if="page == 'IndexView'" :posts="posts" />
        <UsersView v-if="page == 'UsersView'" :users="users" />
        <RegisterPage v-if="page == 'RegisterPage'"/>
    </div>
</template>

<script>
import IndexView from "./IndexView.vue"
import UsersView from "./UsersView.vue"
import RegisterPage from "./page/RegisterPage.vue"

export default {
    name: 'MiddleView',
    components: {
        IndexView,
        UsersView,
        RegisterPage
    },
    props: ["posts", "users"],
    data: function () {
        return {
            page: 'IndexView'
        }
    },
    beforeCreate() {
        this.$root.$on("onChangePage", (page) => this.page = page)
    }
}
</script>