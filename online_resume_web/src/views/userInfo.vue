<template>
  <div>
    <span>用户信息{{user_name}}</span>
    <Button @click="getUserInfo"> test</Button>
    {{userName}} <br />
    {{userPhone}}
  </div>
</template>

<script>
  export default {
    data(){
      return{
        user_name: this.$route.query.user_name,
        userName:'',
        userPhone:''
      }
    },

    methods:{
      getUserInfo () {
        this.$axios
          .get('/UserInfo',{
            params: {
              user_name: this.user_name
              }
          })
          .then(response => {
              this.userName =response.data.user_name;
              this.userPhone =response.data.user_phone
          })
          .catch(failResponse => {
          })
        },
    }
  }
</script>

<style>
</style>
