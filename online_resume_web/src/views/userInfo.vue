<template>
  <div>
    <div class="index">
        <div id="index_pc_bj">
          <div class="wrap_conter">
            <ul>
                <li><h2>个人信息</h2></li>
                <li>
                    <dl>
                        <Input v-model="userName" prefix="md-contact" disabled/>
                          <span>line</span>
                        </Input>
                        <Input v-model="userPhone" prefix="ios-call" disabled/>
                          <span>line</span>
                        </Input>
                    </dl>
                </li>
            </ul>
          </div>
        </div>
    </div>
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

    mounted(){
      this.getUserInfo()
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

<style scoped>
    .index {
        width: 100%;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        text-align: center;
    }
    .index .ivu-row-flex {
        height: 100%;
    }
    #index_pc_bj{width:100%;height:100%;background-size:cover;overflow: hidden;background-position:center center;box-shadow: 0 0px 3px rgba(0,0,0,.5);text-align: center;}
    .wrap_conter ul{position:relative;width:300px;/*border:5px solid rgba(255,255,255,0.3);*/border-radius:5px;box-shadow: 0 0px 5px rgba(0,0,0,.2); margin-top: 10%; margin-left: 40%; text-align:center;}
    .wrap_conter li{text-align:center;color:#fff;font-size:12px;line-height:30px; padding:0 25px 5px 25px;width: 100%;}
    .wrap_conter li h2{color:#ff0f47;font-size:20px;line-height:40px; display:block; text-align:center; padding:20px 0 5px 0}
    .pc-hign{height:75px;display: inline-table;}
    .wrap_conter li dl{width:100%;}
    .name-password-error{
        padding-bottom: 2px;
        text-align: left;
        line-height: 1;
        color: #ed3f14;
    }
</style>
