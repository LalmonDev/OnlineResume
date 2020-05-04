<template>
    <div class="index">
        <div id="index_pc_bj">
            <Form ref="formLogin" :model="formLogin" :rules="ruleLogin">
                <div class="wrap_conter">
                    <ul>
                        <li><h2>用户登录</h2></li>
                        <li>
                            <!-- <div class="name-password-error" v-if="this.$store.state.ifSign">用户名或密码错误</div> -->
                            <dl>
                                <FormItem prop="userName" >
                                    <Input name="userName" v-model="formLogin.userName" type="text" placeholder="登录名" >
                                        <Icon type="ios-person-outline" slot="prepend" ></Icon>
                                    </Input>
                                </FormItem>
                                <FormItem prop="password">
                                    <Input name="password" v-model="formLogin.password" type="password" placeholder="密码" >
                                        <Icon type="ios-lock-outline" slot="prepend"></Icon>
                                    </Input>
                                </FormItem>
                                <FormItem style="margin-bottom: 60px;text-align: center">
                                    <Button type="primary"  @click="login('formLogin')" style="width: 45%">登录</Button>
                                    <Button style="width: 45%" type="primary" @click="register()">注册</Button>
                                </FormItem>
                                <FormItem>
                                  <router-link to="/forgetpasswd">
                                    <el-link type="primary">忘记密码</el-link>
                                  </router-link>
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
      name: 'login',
        data(){
            return {
                formLogin:{
                    userName: '',
                    password: ''
                },
                ruleLogin: {
                        userName: [{ required: true, message: '请填写用户名', trigger: 'blur' }],
                        password: [{ required: true, message: '请填写密码', trigger: 'blur' }]
                }
            }
        },
        methods: {

            login(formLogin){
                this.$refs[formLogin].validate((valid) => {
                    if(valid){
                        if((this.formLogin.userName == "admin") && (this.formLogin.password == "admin")){
                          this.$router.replace({path:'/manage'})
                        } else {
                          this.$axios
                            .post('/login',{
                              user_name: this.formLogin.userName,
                              user_password: this.formLogin.password
                            })
                            .then(response => {
                              let code = response.data.code
                              if(code == 200){
                                this.$router.replace({path:'/user_index',query:{user_name:this.formLogin.userName}})
                              }else if(code == 400){
                                this.$Message.info('用户名或密码错误 请重新登录！');
                                this.formLogin.userName = null;
                                this.formLogin.password = null
                              }
                            })
                            .catch(failResponse => {
                            })
                        }
                    }
                 })
            },
            register(){
              this.$router.push({path:'/register'})
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
