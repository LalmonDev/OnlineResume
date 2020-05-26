<template>
    <div class="index">
        <div id="index_pc_bj">
            <Form ref="formLogin" :model="formLogin" :rules="ruleLogin">
                <div class="wrap_conter">
                    <ul>
                        <li><h2>密码找回</h2></li>
                        <li>
                            <dl>
                                <FormItem prop="phone" >
                                    <Input name="phone" v-model="formLogin.phone" type="text" placeholder="输入注册手机号" >
                                        <Icon type="ios-call" slot="prepend" ></Icon>
                                    </Input>
                                </FormItem>
                                <FormItem style="margin-bottom: 60px;text-align: center">
                                    <Button type="primary"  @click="check('formLogin')" style="width: 45%">校验</Button>
                                </FormItem>
                            </dl>
                        </li>
                    </ul>
                </div>
            </Form>
        </div>
    </div>
</template>
<script>
    export default {
      name: 'findPasswd',
        data(){
            return {
                formLogin:{
                    phone: ''
                },
                ruleLogin: {
                        phone: [{ required: true, message: '请填写您注册时的手机号', trigger: 'blur' }]
                }
            }
        },
        methods: {
            check(formLogin){
                this.$refs[formLogin].validate((valid) => {
                    if(valid){
                        this.$axios
                          .get('/findUserName',{
                            params: {
                              user_phone: this.formLogin.phone
                            }
                          })
                          .then(response => {
                            let userName = response.data.user_name;
                            if(userName != null){
                              this.$router.replace({path:'/passwdReset',query:{user_name:userName}})
                            }else{
                              this.$Message.info('手机号校验错误，请重新输入！');
                              this.formLogin.phone = null
                            }
                          })
                          .catch(failResponse => {
                          })
                    }
                 })
            }
        }
    };
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
    #index_pc_bj{width:100%;height:100%;background-image: url(../assets/login.jpg);background-size:cover;overflow: hidden;background-position:center center;box-shadow: 0 0px 3px rgba(0,0,0,.5);text-align: center;}
    .wrap_conter ul{position:relative;width:300px;/*border:5px solid rgba(255,255,255,0.3);*/border-radius:5px;box-shadow: 0 0px 5px rgba(0,0,0,.2); margin-top: 10%; margin-left: 40%; text-align:center;}
    .wrap_conter li{text-align:center;color:#fff;font-size:12px;line-height:30px; padding:0 25px 5px 25px;width: 100%;}
    .wrap_conter li h2{color:#aaaaff;font-size:20px;line-height:40px; display:block; text-align:center; padding:20px 0 5px 0}
    .pc-hign{height:75px;display: inline-table;}
    .wrap_conter li dl{width:100%;}
    .name-password-error{
        padding-bottom: 2px;
        text-align: left;
        line-height: 1;
        color: #ed3f14;
    }
</style>
