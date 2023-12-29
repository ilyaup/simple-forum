import { createRouter, createWebHashHistory } from 'vue-router'
import IndexPage from './components/page/IndexPage.vue'
import UsersPage from './components/page/UsersPage.vue'
import RegisterPage from './components/page/RegisterPage.vue'
import LoginPage from './components/page/LoginPage.vue'
import WritePostPage from './components/page/WritePostPage.vue'
import InfoPage from './components/page/InfoPage.vue'

export default createRouter({
    history: createWebHashHistory(),
    routes: [{ path: '/', component: IndexPage },
    { path: '/users', component: UsersPage },
    { path: '/register', component: RegisterPage },
    { path: '/login', component: LoginPage },
    { path: '/post', component: WritePostPage },
    { path: '/info', component: InfoPage },
    ]
})