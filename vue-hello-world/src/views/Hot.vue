<template>
  <div class="test">

    <!-- 按钮 -->
    <div type="flex" class="right" justify="end">
      <Row type="flex" justify="end" class="code-row-bg">
        <Button type="info" @click="AddBtnShow()">新增</Button>
        <Button type="success" @click="HotQryQry()">查询</Button>
      </Row>
    </div>

    <!-- 列表 -->
    <div>
      <Table border :columns="columns" :data="dataList">
        <template slot-scope="scope" slot="action">
          <!-- <Button type="primary" size="small" style="margin-right: 5px" @click="EditBtnShow(row)">修改</Button> -->
          <Button type="error"   size="small"  @click="HotDel(scope.row)">删除</Button>
          <Button type="success" size="small"  @click.stop="sortUp(scope.index, scope.row)">向上↑</Button>
          <Button type="primary" size="small"  @click.stop="sortDown(scope.index, scope.row)">向下↓</Button>
        </template>
      </Table>
    </div>

    <!-- 增加用户 -->
    <div>
      <Modal v-model="isAddShow" draggable footer-hide scrollable title="增加热词">
        <Form ref="addFormList" :model="addFormList"  :label-width="80">
          <FormItem label="热词名称" prop="name">
            <Input v-model="addFormList.name" placeholder="请输入热词名称"/>
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
      <Modal v-model="isEditShow" draggable footer-hide scrollable title="修改热词">
        <Form ref="editFormList" :model="editFormList"  :label-width="80">
          <FormItem label="热词名称" prop="name">
            <Input v-model="addFormList.no" placeholder="请输入热词名称" number />
          </FormItem>
          <FormItem>
            <Button type="primary" @click="HandleSubmit('addFormList')">提交</Button>
            <Button @click="HandleReset('addFormList')" style="margin-left: 8px">重置</Button>
          </FormItem>
        </Form>
      </Modal>
    </div>

  </div>
</template>

<script>
  import vuedraggable from 'vuedraggable';
  import { HotQryAction, HotAddAction, HotDelAction } from "../api/hot.js";
  export default {
    data() {
      return {
        isAddShow: false,
        isEditShow: false,
        columns: [{
            title: "热词名称",
            key: "name"
          },
          {
            title: "数量",
            key: "number"
          },
          {
            title: "操作",
            slot: "action",
            width: 180,
            align: "center"
          }
        ],
        dataList: [],
        addFormList: {
          name: ""
        },
        editFormList: {
          name: ""
        }
      };
    },
    methods: {
      
      // 上移按钮
      sortUp (index, row) {
        if (index === 0) {
          this.$message({
            message: '已经是列表中第一个素材！',
            type: 'warning'
          })
        } else {
          let temp = this.dataList[index - 1]
          this.$set(this.dataList, index - 1, this.dataList[index])
          this.$set(this.dataList, index, temp)
        }
      },
      
      // 下移按钮
      sortDown (index, row) {
        debugger
        if (index === (this.dataList.length - 1)) {
          this.$message({
            message: '已经是列表中最后一个素材！',
            type: 'warning'
          })
        } else {
          let i = this.dataList[index + 1]
          this.$set(this.dataList, index + 1, this.dataList[index])
          this.$set(this.dataList, index, i)
        }
      },
      HotQryQry() {
        HotQryAction().then(res => {
          this.dataList = res.data.data;
        });
      },
      HotAdd() {
        let flag = this.FindHot();
        if (flag) {
          this.$Message.error("热词已经存在！");
          return;
        }
        HotAddAction(this.addFormList).then(res => {
          this.AddBtnNotShow();
          this.HotQryQry();
          this.$Message.success("增加成功！");
        });
      },
      HandleSubmit(name) {
        this.$refs[name].validate(valid => {
          if (valid) {
            if (this.isAddShow) {
              this.HotAdd();
            } else if (this.isEditShow) {
              this.HotAdd();
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
        this.editFormList.name = item.name
      },
      EditBtnNotShow() {
        this.isEditShow = false;
      },
      HandleReset(name) {
        this.$refs[name].resetFields();
      },
      FindHot() {
        let flag = false;
        this.dataList.forEach(item => {
          if (item.name == this.addFormList.name) flag = true;
        });
        return flag;
      },
      HotDel(item) {
        HotDelAction(item.name).then(res => {
          this.HotQryQry();
          this.$Message.success("删除成功！");
        });
      },
    },
    mounted() {
      this.HotQryQry();
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