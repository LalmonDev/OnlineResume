<template>
    <div class="layout">
        <Layout>
            <Header :style="{ width: '100%'}">
                <Menu mode="horizontal" theme="dark" active-name="user_menu">
                    <div class="layout-logo">
                      <MenuItem name="logo">
                          你好，{{user_name}}
                      </MenuItem>
                    </div>
                    <div class="layout-nav">
                        <MenuItem name="new_resume">
                            <Icon type="ios-add-circle-outline" />
                            新建简历
                        </MenuItem>
                        <MenuItem name="view_resume">
                            <Icon type="md-eye" />
                            预览简历
                        </MenuItem>
                        <MenuItem name="download_resume">
                            <Icon type="md-cloud-download" />
                            导出简历
                        </MenuItem>
                        <MenuItem name="owner_info" @click.native="getUserInfo">
                            <Icon type="md-contact" />
                            个人信息
                        </MenuItem>
                    </div>
                </Menu>
            </Header>
            <Content :style="{margin: '20px 20px 0', background: '#fff', minHeight: '500px'}">
                 <div id="show_user_info">
                   <ul><span>用户名：{{userName}}</span></ul>
                   <ul><span>手机号：{{userPhone}}</span></ul>
                 </div>
            </Content>
            <Footer class="layout-footer-center">2019-2020 &copy; LalmonDev</Footer>
        </Layout>
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
                user_name: 'luo'
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
    .layout{
        width: 100%;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        text-align: center;
    }
    .layout-logo{
        width: 200px;
        height: 30px;
        border-radius: 3px;
        float: left;
        position: relative;
        top: 5px;
        left: 20px;
    }
    .layout-nav{
        width: 500px;
        margin: 0 auto;
        margin-right: 20px;
    }
    .layout-footer-center{
        text-align: center;
    }
</style>
