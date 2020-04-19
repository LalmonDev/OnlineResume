<template>
    <div class="layout">
        <Layout>
            <Header :style="{ width: '100%'}">
                <Menu @on-select="handleSelect" mode="horizontal" theme="dark" >
                    <div class="layout-logo">
                      <MenuItem name="logo">
                          <span>欢迎：<label>{{user_name}}</label></span>
                      </MenuItem>
                    </div>
                    <div class="layout-nav">
                        <MenuItem name="newResume">
                            <Icon type="ios-add-circle-outline" />
                            新建简历
                        </MenuItem>
                        <MenuItem name="showResume">
                            <Icon type="md-eye" />
                            预览简历
                        </MenuItem>
                       <!-- <MenuItem name="downloadResume">
                            <Icon type="md-cloud-download" />
                            导出简历
                        </MenuItem> -->
                        <MenuItem name="userInfo">
                            <Icon type="md-contact" />
                            个人信息
                        </MenuItem>
                    </div>
                </Menu>
            </Header>
           <Content :style="{margin: '20px 20px 0', background: '#fff', minHeight: '500px'}">
                 <div id="show_user_info">
                   <router-view></router-view>
                 </div>
            </Content>
            <Footer class="layout-footer-center">2019 - 2020 &copy; LalmonDev</Footer>
        </Layout>
    </div>
</template>
<script>
    export default {
      data(){
        return{
          user_name: this.$route.query.user_name
        }
      },

      methods:{
        handleSelect(name){
          this.$router.push({path:name,query:{user_name:this.user_name}})
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
