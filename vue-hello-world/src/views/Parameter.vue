<template>
  <div class="test">

    <!-- 按钮
    <div type="flex" class="right" justify="end">
      <Row type="flex" justify="end" class="code-row-bg">
        <Button type="info" @click="AddBtnShow()">新增</Button>
      </Row>
    </div> -->

    <!-- 列表 -->
    <div>
      <Table border :columns="columns" :data="dataList">
        <template slot-scope="{row}" slot="action">
          <Button type="primary" size="small" style="margin-right: 5px" @click="EditBtnShow(row)">修改</Button>
          <!-- <Button type="error" size="small" @click="UserDel(row)">删除</Button> -->
        </template>
      </Table>
    </div>

    <!-- 增加用户 -->
    <div>
      <Modal v-model="isAddShow" draggable footer-hide scrollable title="增加用户">
        <Form ref="addFormList" :model="addFormList"  :label-width="80">
          <FormItem label="Id" prop="no">
            <Input v-model="addFormList.no" placeholder="请输入你的编号" number />
          </FormItem>
          <FormItem label="姓名" prop="name">
            <Input v-model="addFormList.name" placeholder="请输入你的姓名" />
          </FormItem>
          <FormItem label="邮箱" prop="email">
            <Input v-model="addFormList.email" placeholder="请输入你的邮箱" />
          </FormItem>
          <FormItem>
            <Button type="primary" @click="HandleSubmit('addFormList')">提交</Button>
            <Button @click="HandleReset('addFormList')" style="margin-left: 8px">重置</Button>
          </FormItem>
        </Form>
      </Modal>
    </div>

    <!-- 修改用户 -->
    <div>
      <Modal v-model="isEditShow" draggable footer-hide scrollable title="修改用户">
        <Form ref="editFormList" :model="editFormList"  :label-width="80">
          <FormItem label="id" prop="paraId">
            <Input disabled v-model="editFormList.paraId" placeholder="请输入id" />
          </FormItem>
          <FormItem  label="描述" prop="paraName">
            <Input disabled v-model="editFormList.paraName" placeholder="请输入描述" />
          </FormItem>
          <FormItem label="参数值" prop="paraValue">
            <Input v-model="editFormList.paraValue" placeholder="请输入参数值" />
          </FormItem>
          <FormItem>
            <Button type="primary" @click="HandleSubmit('editFormList')">提交</Button>
            <!-- <Button @click="HandleReset('editFormList')" style="margin-left: 8px">重置</Button> -->
          </FormItem>
        </Form>
      </Modal>
    </div>

  </div>
</template>

<script>
  import { ParameterQryAction, ParameterUpdateAction } from "../api/parameter.js";
  export default {
    data() {
      return {
        isAddShow: false,
        isEditShow: false,
        columns: [{
            title: "Id",
            key: "paraId"
          },
          {
            title: "描述",
            key: "paraName"
          },
          {
            title: "参数值",
            key: "paraValue"
          },
          {
            title: "操作",
            slot: "action",
            width: 150,
            align: "center"
          }
        ],
        dataList: [],
        addFormList: {
          paraId: "",
          paraName: "",
          paraValue: ""
        },
        editFormList: {
          paraId: "",
          paraName: "",
          paraValue: ""
        }
      };
    },
    methods: {
      ParameterQry() {
        ParameterQryAction().then(res => {
          this.dataList = res.data.data;
        });
      },
      // UserAdd() {
      //   let flag = this.FindUser();
      //   if (flag) {
      //     this.$Message.error("编号已经存在！");
      //     return;
      //   }
      //   UserAddAction(this.addFormList).then(res => {
      //     this.AddBtnNotShow();
      //     this.UserQry();
      //     this.$Message.success("增加成功！");
      //   });
      // },
      ParameterUpdate() {
        ParameterUpdateAction(this.editFormList).then(res => {
          this.EditBtnNotShow();
          this.ParameterQry();
          this.$Message.success("修改成功！");
        });
      },
      // UserDel(item) {
      //   UserDelAction(item.no).then(res => {
      //     this.UserQry();
      //     this.$Message.success("删除成功！");
      //   });
      // },
      HandleSubmit(name) {
        this.$refs[name].validate(valid => {
          if (valid) {
            if (this.isAddShow) {
              this.UserAdd();
            } else if (this.isEditShow) {
              this.ParameterUpdate();
            }
          } else {
            this.$Message.error("填写信息错误!");
          }
        });
      },
      AddBtnShow() {
        this.HandleReset("addFormList");
        this.isAddShow = true;
      },
      AddBtnNotShow() {
        this.isAddShow = false;
      },
      EditBtnShow(item) {
        this.isEditShow = true;
        this.editFormList.paraId = item.paraId;
        this.editFormList.paraName = item.paraName;
        this.editFormList.paraValue = item.paraValue;
      },
      EditBtnNotShow() {
        this.isEditShow = false;
      },
      HandleReset(name) {
        this.$refs[name].resetFields();
      },
      FindUser() {
        let flag = false;
        this.dataList.forEach(item => {
          if (item.no == this.addFormList.no) flag = true;
        });
        return flag;
      }
    },
    mounted() {
      this.ParameterQry();
    }
  };
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .test {
    margin: 20px;
  }

  .right {
    margin: 15px;
  }
</style>