<template>
    <div class="layout">
        <Layout>
            <Header :style="{ width: '100%'}">
               <Row type="flex" style="position:absolute;left:0;top:0;width:100%;">
                 <Col span="4" class="layout-menu-left">
                <div class="layout-header">
                  <Dropdown trigger="click" style="margin-right: 10px" @on-click="logout()" >
                    <span><label><strong>欢迎：管理员</strong></label></span>
                    <DropdownMenu class="dropdown-menu" slot="list">
                      <DropdownItem>注销</DropdownItem>
                    </DropdownMenu>
                  </Dropdown>
                </div>
                </Col>
                </Row>
            </Header>
           <Content :style="{margin: '20px 20px 0', background: '#fff', minHeight: '500px'}">
            <div>
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

        }
      },

      methods:{
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
