<template>
  <div>
    <iframe :src="url" id="iframe" style="width: 100%;" @load="sureHeight"></iframe>
  </div>
</template>

<script>
export default {
  // 返回数据
  data () {
    return {
      url: '',
      file_path: ''
    }
  },
  // 模块创建时执行
  created () {
    this.file_path = '/static/pdf/web/luo/test.pdf'
  },
  // 模块渲染时执行
  mounted () {
    // 本地请求文件

    let filePath = encodeURIComponent(this.file_path)
    // 跨域请求文件，需走后台代理
    // let filePath2 = encodeURIComponent('/pdf/showPdf?pdfUrl=http://test.hccb.cc/corporBankWXTest/static/123.pdf')
    // pdf文档展示的页面
    this.url = '/static/pdf/web/viewer.html?file=' + filePath
  },
  // 定义模块测试方法
  methods: {
    // 此方法用于动态确定元素iframe的高度，使展示的pdf文档占满整个屏幕
    sureHeight: function () {
      let element = document.getElementById('iframe')
      element.style.height = window.screen.height + 'px'
    }
  }
}
</script>

<style scoped>

</style>
