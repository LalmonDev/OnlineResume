<template>
    <div class="index">
        <div id="index_pc_bj">
            <Form ref="formRegister" :model="formRegister" :rules="ruleRegister">
                <div class="wrap_conter">
                    <ul>
                        <li><h2>用户注册</h2></li>
                        <li>
                            <!-- <div class="name-password-error" v-if="this.$store.state.ifSign">用户名或密码错误</div> -->
                            <dl>
                                <FormItem prop="user_name" >
                                    <Input v-model="formRegister.user_name" type="text" placeholder="登录名" >
                                        <Icon type="ios-person-outline" slot="prepend" ></Icon>
                                    </Input>
                                </FormItem>
                                <FormItem prop="user_password">
                                    <Input v-model="formRegister.user_password" type="password" placeholder="密码" >
                                        <Icon type="ios-lock-outline" slot="prepend"></Icon>
                                    </Input>
                                </FormItem>
                                <FormItem prop="user_phone">
                                    <Input v-model="formRegister.user_phone" type="text" placeholder="手机号" >
                                        <Icon type="ios-call-outline" slot="prepend"></Icon>
                                    </Input>
                                </FormItem>
                                <FormItem>
                                    <Button type="primary" @click="register('formRegister')" style="width: 250px">提交</Button>
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
      name: 'register',
        data(){
            return {
                dialogVisible: false,
                formRegister:{
                    user_name: null,
                    user_password: null,
                    user_phone: null
                },
                ruleRegister: {
                        user_name: [
                            { required: true, message: '请填写用户名', trigger: 'blur' }
                        ],
                        user_password: [
                            { required: true, message: '请填写密码', trigger: 'blur' },
                        ],
                        user_phone: [
                            { required: true, message: '请填写手机号', trigger: 'blur' },
                        ]
                }
            }
        },
        methods: {
            register(formRegister){
                this.$refs[formRegister].validate((valid) => {
                    if(valid){
                      if(this.formRegister.user_name == "admin"){
                          this.$Message.info('该账户不允许注册')
                          this.formRegister.user_name = null;
                          this.formRegister.user_password = null;
                          this.formRegister.user_phone = null;
                          return
                        }

                        this.$axios
                          .post('/register',{
                            user_name: this.formRegister.user_name,
                            user_password: this.formRegister.user_password,
                            user_phone: this.formRegister.user_phone
                          })
                          .then(response => {
                            let code = response.data.code
                            if(code == 200){
                              alert('注册成功')
                              this.$router.push({path:'/'})
                              dialogVisible: true
                            }else if(code == 201){
                              this.$Message.info('用户已存在')
                              this.formRegister.user_name = null;
                              this.formRegister.user_password = null;
                              this.formRegister.user_phone = null
                            }else if(code == 400){
                              this.$Message.info('参数错误，请重新填写！')
                              this.formRegister.user_name = null;
                              this.formRegister.user_password = null;
                              this.formRegister.user_phone = null
                            }
                          })
                          .catch(failResponse => {
                          })
                    }
                })
            },
			goto_login(){
				this.$router.push({path:'/login'})
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
