<template>
  <div >
    <div>
      <input type="text"  @blur="HotAdd()" v-model="searchName.name" placeholder="请输入关键词进行搜索" class="searchInput" style="padding-left: 10px;">
      <input type="button" @click="HandleReset()" value="取消" class="searchButton">
    </div>
    <br>    <br>    <br>    <br>    <br>   
    <div class="hot">
      <h2 class="title">历史记录</h2>
      <ul class="list">
        <li class="item" v-for="(item,index) in hotHist" :key="index">
          {{item}}
      </li>
      </ul>
    </div>
    <br>    <br>    <br>    <br>    <br>   
    <div>
      <h2 class="title">今日热搜</h2>
      <ul class="list">
        <li class="item" v-for="(item,index) in hots" :key="index">
          {{item}}
      </li>
      </ul>
    </div>
    </div>
</template>

<script>
import { HotQryAction, HotHistQryAction, HotAddAction} from "../api/hot.js";
export default {
  name: 'HelloWorld',
  data () {
    return {
      searchName:{
        name: "",
      },
      hotHist:[],
      hots:[]
    }
  },
  methods:{
    HandleReset() {
      this.searchName.name = "";
    },
    HotQryQry() {
      HotQryAction().then(res => {
        let array = res.data.data;
        for (let index = 0; index < array.length; index++) {
          const name = array[index].name;
          this.hots.push(name);
        }
      });
    },
    HotHistQry() {
      HotHistQryAction().then(res => {
        let array = res.data.data;
        for (let index = 0; index < array.length; index++) {
          const name = array[index].name;
          this.hotHist.push(name);
        }
      });
    },
    HotAdd() {
        HotAddAction(this.searchName).then(res => {
          this.hots = [];
          this.hotHist = [];
          this.HotQryQry();
          this.HotHistQry();
        });
      }
  },

  mounted() {
    this.HotQryQry();
    this.HotHistQry();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .searchInput{
    display: inline-block;
    width: 85%;
    height: 38px;
    border: 1px solid #cccccc;
    float: left;
    box-sizing: border-box;
    -moz-box-sizing:border-box; /* Firefox */
    -webkit-box-sizing:border-box; /* Safari */
    border-bottom-left-radius: 5px;
    border-top-left-radius: 5px;
  }
  .searchButton{
    display: inline-block;
    width: 15%;
    height: 38px;
    line-height: 40px;
    float: left;
    background-color: #00a0e9;
    font-size: 16px;
    cursor: pointer;
    border-bottom-right-radius: 5px;
    border-top-right-radius: 5px;
    border: none;
    color: #fff;
  }

  .list {
    display: flex;
    flex-wrap: wrap;
  }
  .item {
    padding: 8px;
    background-color: #f0f2f5;
    border-radius: 4px;
    margin: 0 10px 10px 0;
    color: #686868;
    font-size: initial;
  }
  .hot{
    padding-left: 10px;
    background-color: #fff;
    border-bottom: 1px solid border-color;
    margin-bottom: 10px;
  }
  .title {
    margin-right: 293px;
  }

</style>
