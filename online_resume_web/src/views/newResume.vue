<template>
  <div id="index">
    <div class="wrap_conter">
      <ul>
         <Divider>基本信息</Divider>
        <br>
      <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
          <Row>
              <Col span="4" >
                  <FormItem label="姓名" prop="name">
                      <Input v-model="formValidate.name" style="width: 200px" placeholder="姓名"></Input>
                  </FormItem>
              </Col>
              <Col span="4" offset="4" >
                <FormItem label="性别" prop="sex">
                    <Input v-model="formValidate.sex" style="width: 200px" placeholder="性别"></Input>
                </FormItem>
              </Col>
              <Col span="4" offset="4">
               <FormItem label="民族" prop="minzu" style="width:200px">
                  <Input v-model="formValidate.minzu" style="width: 200px" placeholder="民族"></Input>
               </FormItem>
               </Col>
          </Row>

        <Row>
          <Col span="4">
              <FormItem label="出生年月" style="width: 200px" prop="date">
                  <DatePicker type="date" style="width: 200px" placeholder="请选择" v-model="formValidate.date"></DatePicker>
              </FormItem>
          </Col>
          <Col span="4" offset="4">
            <FormItem label="政治面貌" style="width: 200px" prop="face">
                <Input v-model="formValidate.face" style="width: 200px" placeholder="政治面貌"></Input>
            </FormItem>
          </Col>
          <Col span="4" offset="4">
            <FormItem label="婚姻状况" prop="marry">
            <Select v-model="formValidate.marry" style="width:200px" >
                <Option value="yihun" >已婚</Option>
                <Option value="weihun">未婚</Option>
                <Option value="liyi">离异</Option>
            </Select>
            </FormItem>
          </Col>
         </Row>

         <Row>
           <Col span="4">
           <FormItem label="籍贯" prop="home" style="width:200px">
              <Input v-model="formValidate.home" style="width: 200px" placeholder="籍贯"></Input>
           </FormItem>
           </Col>
           <Col span="4" offset="4">
            <FormItem label="联系电话" prop="phone" style="width:200px">
               <Input v-model="formValidate.face" style="width: 200px" placeholder="联系电话"></Input>
            </FormItem>
            </Col>
            <Col span="4" offset="4" >
              <FormItem label="邮箱" prop="mail">
                  <Input v-model="formValidate.mail" style="width: 200px" placeholder="邮箱 "></Input>
              </FormItem>
            </Col>
           </Row>

           <Divider>求职意向</Divider><br>
           <Row>
             <Col span="4">
             <FormItem label="求职岗位" prop="job" style="width:200px">
                <Input v-model="formValidate.job" style="width: 200px" placeholder="求职岗位"></Input>
             </FormItem>
             </Col>
             <Col span="4" offset="4">
              <FormItem label="意向城市" prop="city" style="width:200px">
                 <Input v-model="formValidate.city" style="width: 200px" placeholder="意向城市"></Input>
              </FormItem>
              </Col>
              <Col span="4" offset="4" >
                <FormItem label="期望薪资" prop="money">
                    <Input v-model="formValidate.money" style="width: 200px" placeholder="期望薪资 "></Input>
                </FormItem>
              </Col>
             </Row>

          <Divider>教育背景</Divider><br>
          <Row>
                <Col span="2">
                  <FormItem label="起止日期" prop="study_start_day">
                    <DatePicker type="date" style="width: 110px" placeholder="入学年月" v-model="formValidate.study_start_day"></DatePicker>
                  </FormItem>
                </Col>
                <Col span="2" offset="1">
                  <FormItem prop="study_stop_day">
                    <DatePicker type="date" style="width: 110px" placeholder="毕业年月" v-model="formValidate.study_stop_day"></DatePicker>
                  </FormItem>
                </Col>
              </Row>

          <Row>
            <Col span="4">
            <FormItem label="学校" prop="school" style="width:200px">
               <Input v-model="formValidate.school" style="width: 200px" placeholder="学校"></Input>
            </FormItem>
            </Col>
            <Col span="4" offset="4">
             <FormItem label="专业" prop="major" style="width:200px">
                <Input v-model="formValidate.major" style="width: 200px" placeholder="专业"></Input>
             </FormItem>
             </Col>
             <Col span="4" offset="4" >
               <FormItem label="学位" prop="xuewei">
                   <Input v-model="formValidate.xuewei" style="width: 200px" placeholder="学位 "></Input>
               </FormItem>
             </Col>
            </Row>
            <Row>
              <FormItem label="描述" style="width:1000px" prop="school_descrip" v-model="formValidate.school_descrip">
                <Input v-model="formValidate.school_descrip" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入"></Input>
              </FormItem>
            </Row>

          <Divider>其他</Divider><br>
          <FormItem label="爱好" style="width:1000px" prop="hobby" v-model="formValidate.hobby">
            <Input v-model="formValidate.desc" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入"></Input>
          </FormItem>


          <FormItem>
              <Button type="primary" @click="handleSubmit('formValidate')">提交</Button>
              <Button @click="handleReset('formValidate')" style="margin-left: 8px">重置</Button>
          </FormItem>
      </Form>
      </ul>
    </div>
    </div>
</template>
<script>
    export default {
        data () {
            return {
                formValidate: {
                    name: '',
                    mail: '',
                    city: '',
                    gender: '',
                    interest: [],
                    date: '',
                    time: '',
                    desc: ''
                },
                ruleValidate: {
                    name: [
                        { required: true, message: '姓名不能为空', trigger: 'blur' }
                    ],
                    mail: [
                        { required: true, message: 'Mailbox cannot be empty', trigger: 'blur' },
                    ],
                    city: [
                        { required: true, message: 'Please select the city', trigger: 'change' }
                    ],
                    gender: [
                        { required: true, message: 'Please select gender', trigger: 'change' }
                    ],
                    interest: [
                        { required: true, type: 'array', min: 1, message: 'Choose at least one hobby', trigger: 'change' },
                        { type: 'array', max: 2, message: 'Choose two hobbies at best', trigger: 'change' }
                    ],
                    date: [
                        { required: true, type: 'date', message: 'Please select the date', trigger: 'change' }
                    ],
                    time: [
                        { required: true, type: 'string', message: 'Please select time', trigger: 'change' }
                    ],
                    desc: [
                        { required: true, message: 'Please enter a personal introduction', trigger: 'blur' },
                        { type: 'string', min: 20, message: 'Introduce no less than 20 words', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('Success!');
                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            },
            handleReset (name) {
                this.$refs[name].resetFields();
            }
        }
    }
</script>

<style>
  #index_pc_bj{width:100%;height:100%;background-size:cover;overflow: hidden;background-position:center center;box-shadow: 0 0px 3px rgba(0,0,0,.5);text-align: center;}
  .wrap_conter ul{position:relative;width:1100px;border:5px solid rgba(255,255,255,0.3);border-radius:5px;box-shadow: 0 0px 5px rgba(0,0,0,.2); margin-top: 1%; margin-left: 8%; text-align:center;}
  .wrap_conter li{text-align:center;color:#fff;font-size:12px;line-height:30px; padding:0 25px 5px 25px;width: 100%;}
  .pc-hign{height:75px;display: inline-table;}
  .wrap_conter li dl{width:100%;}
  .name-password-error{
      padding-bottom: 2px;
      text-align: left;
      line-height: 1;
      color: #ed3f14;
  }
</style>
