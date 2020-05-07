<template>
  <div class="wrap">
    <iframe :src="pSrc" width="100%" height="100%"></iframe>
  </div>
</template>

<script>
  export default {
    name: "pdf",
    data() {
      return {
        pSrc:'',
      };
    },
    methods: {
      loadPDF () {
        //baseurl ：pdf存放的文件路径，可以是本地的，也可以是远程，这个是远程的，亲测可以用
        let baseurl = 'http://image.cache.timepack.cn/nodejs.pdf';
        //ie有缓存加个随机数解决  + '?r=' + new Date()
        let pSrc = baseurl + '?r=' + new Date();
        this.pSrc = '../../plugin/pdf/web/viewer.html?file=' + encodeURIComponent(pSrc) + '.pdf';
      },
    },

    mounted: function() {
      this.loadPDF();
    }

  };
</script>

<style scoped>
.wrap{
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  bottom: 0;
}
</style>

