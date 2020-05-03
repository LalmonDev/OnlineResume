<template>
    <div class="index">
        <div id="index_pc_bj">
            <Form ref="formLogin" :model="formLogin" :rules="ruleLogin">
                <div class="wrap_conter">
                    <ul>
                        <li><h2>你好, {{userName}}</h2></li>
                        <li>
                            <dl>
                                <FormItem prop="password" >
                                    <Input name="password" v-model="formLogin.password" type="password" placeholder="输入密码" >
                                        <Icon type="ios-lock-outline" slot="prepend" ></Icon>
                                    </Input>
                                </FormItem>
                                <FormItem prop="repassword" >
                                    <Input name="repassword" v-model="formLogin.repassword" type="password" placeholder="再次输入密码" >
                                        <Icon type="md-lock" slot="prepend" ></Icon>
                                    </Input>
                                </FormItem>
                                <FormItem style="margin-bottom: 60px;text-align: center">
                                    <Button type="primary"  @click="check('formLogin')" style="width: 45%">确认</Button>
                                    <Button type="primary"  @click="reset()" style="width: 45%">重置</Button>
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
      name: 'passwdReset',
        data(){
            return {
                userName: this.$route.query.user_name,
                formLogin:{
                    password: '',
                    repassword: ''
                },
                ruleLogin: {
                        password: [{ required: true, message: '请填写密码', trigger: 'blur' }],
                        repassword: [{ required: true, message: '请填写密码', trigger: 'blur' }]
                }
            }
        },
        methods: {
            check(formLogin){
                this.$refs[formLogin].validate((valid) => {
                    if(valid){
                      if(this.formLogin.password == this.formLogin.repassword){
                        this.$axios
                          .post('/findPasswd', {user_name:this.userName,user_password: this.formLogin.password})
                          .then(response => {
                            let code = response.data.code
                            if(code == 200){
                              this.$Message.info('修改成功，请登录');
                              this.$router.replace({path:'/'})
                            }else{
                              this.$Message.info('连接服务器失败，请重试！');
                              this.formLogin.password = null;
                              this.formLogin.repassword = null
                            }
                          })
                          .catch(failResponse => {
                          })
                      }else{
                        this.$Message.info('两次输入密码不一致，请重新输入！');
                        this.formLogin.password = null;
                        this.formLogin.repassword = null
                      }
                    }
                 })
            },
            reset(){
              this.formLogin.password = null;
              this.formLogin.repassword = null
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
    #index_pc_bj{width:100%;height:100%;background-size:cover;overflow: hidden;background-position:center center;box-shadow: 0 0px 3px rgba(0,0,0,.5);text-align: center;}
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
