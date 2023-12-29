<script>
export default {
    props: ["user"]
}
</script>

<template>
    <tr>
        <td>{{ user.login }}</td>
        <td>{{ user.email }}</td>
        <td>{{ user.rating }}</td>
    </tr>
</template>
