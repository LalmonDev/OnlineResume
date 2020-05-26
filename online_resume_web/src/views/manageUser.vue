<template>
	<div style="margin: 20px;">
        <div></div>
        <div>
            <ul>
                  <Row style="left: auto">
                    <Button type="primary" icon="plus-round" @click="openNewModal()">新建</Button>
                    <!-- <Button type="success" icon="wrench" @click="openModifyModal()">修改</Button> -->
                    <Button type="error" icon="trash-a" @click="del()">删除</Button>
                  </Row>
                    <br>
                    <div style="padding: 10px 0;" align="center">
                    	<Table border :columns="table_columns" :data="table_data" :width="600" :height="500" @on-selection-change="s=>{change(s)}"></Table>
                    </div>

            </ul>
        </div>

        <!--添加modal-->
        <Modal :mask-closable="false" :visible.sync="newModal" :loading = "loading" v-model="newModal" width="600" title="新建" @on-ok="newOk('userNew')" @on-cancel="cancel()">
            <Form ref="userNew" :model="userNew" :rules="ruleNew" :label-width="80" >
                <Row>
                    <Col span="12">
                        <Form-item label="用户名:" prop="user_name">
                            <Input v-model="userNew.user_name" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="手机号:" prop="user_phone">
                            <Input v-model="userNew.user_phone" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="密码:" prop="user_password">
                            <Input v-model="userNew.user_password" type="password" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                  <Col span="12">
                      <Form-item label="确认密码:" prop="user_passwordAgain">
                          <Input v-model="userNew.user_passwordAgain" type="password" style="width: 204px"/>
                      </Form-item>
                  </Col>
                </Row>
            </Form>
        </Modal>
      </div>
</template>

<script>
	export default {
        data () {
            return {
            	/*新建modal的显示参数*/
                newModal:false,

                /*loading*/
                loading: true,

                /*用户表数据*/
                table_data: [],

                /*删除用户列表*/
                delUserList: [],

                /*user实体*/
                user:{
                  user_name:null,
                  user_password:null,
                  user_phone:null
                },
                /*用于添加的user实体*/
                userNew:{
                  user_name:null,
                  user_password:null,
                  user_passwordAgain:null,
                  user_phone:null
                },

                /*新建用户验证*/
                ruleNew:{
                    user_name: [
                        { type:'string',required: true, message: '输入用户名', trigger: 'blur' }
                    ],
                    user_phone: [
                        { type:'string',required: true, message: '输入手机号', trigger: 'blur' }
                    ],
                    user_password: [
                        { type:'string',required: true, message: '输入密码', trigger: 'blur' }
                    ],
                    user_passwordAgain: [
                        { type:'string',required: true, message: '输入再次密码', trigger: 'blur' }
                    ]
                },

            	/*表显示字段*/
            	table_columns: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '用户名',
                        align: 'center',
                        key: 'user_name'
                    },
                    {
                        title: '手机号',
                        align: 'center',
                        key: 'user_phone'
                    },
                ],

                /*表显示字段*/
                columns2: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '角色名称',
                        width: 120,
                        key: 'name'
                    },
                    {
                        title: '描述',
                        key: 'describe'
                    }
                ],

            }
        },

        mounted(){
        	/*页面初始化调用方法*/
            this.getTable();
        },

        methods:{
            /*user实体初始化*/
            initUser(){
                this.user.user_name = null;
                this.user.user_password = null;
                this.user.user_phone = null;
            },

            /*userNew实体初始化*/
            initUserNew(){
                this.userNew.user_name = null;
                this.userNew.user_phone = null;
                this.userNew.user_password = null;
                this.userNew.user_passwordAgain = null;
            },

            /*userNew设置*/
            userSet(e){
                this.user.user_name = e.user_name;
                this.user.user_password = e.user_password;
                this.user.user_phone = e.user_phone;
            },
            /*userNew设置*/
            userNewSet(e){
                this.userNew.user_name = e.user_name;
                this.userNew.user_password = e.user_password;
                this.userNew.user_passwordAgain = e.user_password;
                this.userNew.user_phone = e.user_phone;
            },

            // /*userModify实体初始化*/
            // initUserModify(){
            //     this.userModify.id = null;
            //     this.userModify.name = null;
            //     this.userModify.loginName = null;
            //     this.userModify.password = null;
            //     this.userModify.email = null;
            // },
            // /*userModify设置*/
            // userModifySet(e){
            //     this.userModify.id = e.id;
            //     this.userModify.name = e.name;
            //     this.userModify.loginName = e.loginName;
            //     this.userModify.password = e.password;
            //     this.userModify.email = e.email;
            // },


            /*得到表数据*/
            getTable() {
                this.$axios
                .get('/getUsers')
                .then(function (response) {
                    var arr = new Array()
                    for(var i=0;i<response.data.length;i++){
                      arr.push(response.data[i])
                    }
                    this.table_data = arr
                }.bind(this)).catch(function (error) {
                  alert(error);
                });
            },


            /*新建点击触发事件*/
            openNewModal(){
                this.newModal = true;
                this.initUserNew();
            },
            /*新建modal的newOk点击事件*/
            newOk (userNew) {
                this.$refs[userNew].validate((valid) => {
                    if (valid) {
                        if(this.userNew.user_password == this.userNew.user_passwordAgain){
                            this.initUser();
                            this.userSet(this.userNew);

                            this.$axios
                            .post('/register',this.user)
                            .then(function (response) {
                              let code = response.data.code
                                if(code == 200){
                                  this.initUserNew();
                                  this.getTable();
                                  this.$Message.info('新建成功');
                                }else if(code == 201){
                                  this.$Message.info('用户已存在');
                                }
                            }.bind(this)).catch(function (error) {
                                alert(error);
                            });
                            this.newModal = false;
                        }else{
                            this.$Message.error('两次输入的密码不相同！');
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }
                    }else {
                        this.$Message.error('表单验证失败!');
                    }
                })
            },

            /*modal的cancel点击事件*/
            cancel () {
                this.$Message.info('点击了取消');
            },

            /*table选择后触发事件*/
            change(e){
              var arr = new Array()
              for(var i=0;i<e.length;i++){
                arr.push(e[i].user_name)
              }
              this.delUserList = arr
            },

            /*根据用户名删除用户*/
            delUser(name){
              this.$axios
              .post('/delete',{user_name: name})
              .then(function (response) {
                this.getTable();
              }
              .bind(this)).catch(function (error) {
                  alert(error);
              });
            },

            /*删除table中选中的数据*/
            del(){
              if (this.delUserList != null){
                for(var i=0;i<this.delUserList.length;i++){
                  this.delUser(this.delUserList[i])
                }
                this.$Message.info('删除成功');
                this.getTable();
              }
            },


            /*点击修改时判断是否只选择一个*/
            openModifyModal(){
                if(this.count > 1 || this.count < 1){
                    this.$Message.warning('只能选择一项修改');
                }else{
                    this.modifyModal = true;
                }
            }



        }
    }
</script>
