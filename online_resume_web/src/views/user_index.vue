<template>
    <div class="layout">
        <Layout>
            <Header :style="{ width: '100%'}">
                  <Row type="flex" style="position:absolute;left:0;top:0;width:100%;">
                    <Col span="4" class="layout-menu-left">
                    <div class="layout-header">
                      <Dropdown trigger="click" style="margin-right: 10px" @on-click="logout()" >
                        <span><label><strong>欢迎,{{user_name}}</strong></label></span>
                        <DropdownMenu class="dropdown-menu" slot="list">
                          <DropdownItem>注销</DropdownItem>
                        </DropdownMenu>
                      </Dropdown>
                    </div>
                    </Col>
                    <Col span="20">
                    <div class="layout-nav">
                      <Menu @on-select="handleSelect" mode="horizontal" theme="dark" >
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
                        </Menu>
                    </div>
                    </Col>
                    </Row>
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
        logout(){
          this.$router.replace({path:'/'})
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
    .layout-header strong{
        color: #00e3e3;
        font-size:20px;
    }
    .dropdown-menu{
        text-align: center;
        /*box-shadow: 0 1px 6px #00BCD4;*/
    }
</style>
