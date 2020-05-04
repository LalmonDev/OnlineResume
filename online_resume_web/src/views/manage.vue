<template>
    <div class="layout">
        <Layout>
            <Header :style="{ width: '100%'}">
                <Menu mode="horizontal" theme="dark" >
                    <div class="layout-logo">
                      <MenuItem name="logo">
                          <span>欢迎：<label>管理员</label></span>
                      </MenuItem>
                    </div>
                </Menu>
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
