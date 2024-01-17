<template>
<!-- board_wrap -->
	<div class="board_wrap">
		<!-- cont_wrap -->
		<div class="cont_wrap">
		<form name="search" id="search" action="./search.do" method="get">
			<input type="hidden" name="startCount" value="0"> 
			<input type="hidden" name="collection" value="ALL">
			<input type="hidden" name="range" value="A">  
			<input type="hidden" name="reQuery" />
			<input type="hidden" name="realQuery" value="">	
			<input type="hidden" name="searchField" >	
			<input type="hidden" name="sort" >	
			<input type="hidden" name="rangeChk" id="rangeChk"  value="N"/>
			
			<!-- dash_board_wrap (left)-->
			<div id="board_left" class="dash_board_wrap left">
				<div class="board_top">
					<!-- 검색옵션 내용 -->
					<div class="box_wrap">
						<div class="detail_box">
							<dl class="inp_list word">
								<span class="logo_hanwha"></span>
								<dd class="inp_area">
									<input type="text" v-model.trim="inputQuery" class="inp_txt w380" title="검색어 입력창" placeholder="검색어 입력" name="query" id="query" @keypress="pressCheck($event)" autocomplete="off">
									<button type="button" class="btn-margin orange margin" @click="doSearch">검색</button>
									<span class="inp_area chk_box_wrap">
										<div class="chk_box">
											<input type="checkbox" name="chk01" id="chk01" class="inp_chk" >
											<label for="chk01"><span class="chk"></span>
												범주검색
											</label>
										</div>
									</span>
								</dd>
							</dl>
						</div>
					</div>
					<!--// 검색옵션 내용 -->
				</div>
				<!-- tab_cont_box : 230110 추가 -->
				<div class="cont_box" v-if="outputQuery != ''">
					<div class="box_wrap">
						<div class="detail_box">
							<dl class="inp_list">
								<dt class="inp_tit">입력된 `{{outputQuery}}`의 결과는 총 {{totalCount}}건 입니다. (0.0 ms)</dt>
								<button id="btn_detail" type="button" class="btn orange margin" @click="showDetail('Spain population?')">상세보기</button>
							</dl>
						</div>
						<div id="div_group_count" class="detail_box box_orange none">
						</div>
					</div>
					<!-- D: id tab-1 기본적으로 active 클래스 추가된 형태 -->
					<div class="tab_cont_box">	
						<div class="box_wrap">
							<div class="cont_box"> 
								<table class="basic_tbl_type file">
									<colgroup>
										<col width="85%;">
										<col width="15%;">
									</colgroup>
									<tbody>
										
										
									</tbody>
								</table>
								
								<div class="page_wrap">
									<div id="page_cont" class="page_btn_num">
										<a class="right" href="#none" title="이전"><span class="ico_comm ico_prev">이전</span></a><a class="right" href="#none" title="다음"><span class="ico_comm ico_next">다음</span></a>
									</div>
								</div>
						
							</div>
						</div>
					</div>
				</div>
				<!--//tab_cont_box : : 230110 추가 -->			
			</div>
			<!--// dash_board_wrap (left) -->

			<!-- dash_board_wrap (right) 
			<div id="board_right" class="dash_board_wrap right">
				<div class="box_wrap tbl">
					<div class="cont_box">
						<div class="tit_box">
							<strong class="tit">전문보기</strong>
						</div>
						<div class="basic_tbl_wrap">
							<div id="board_right_content">
							</div>
						</div>
					</div>
				</div>
			</div>
-->
			<!--// dash_board_wrap (right) -->

			<!--// tab_dimed -->
			
		</form>
		</div>
		<!-- //cont_wrap -->
		
	</div>
	<!-- board_wrap  -->
</template>

<script>
//import moment from 'moment'

export default {
  name: 'BodyContents',
  data() {
    return {
      inputQuery: '',
      outputQuery: '',
			totalCount: 0
    }
  },
	mounted() {
		window.addEventListener('beforeunload', this.unLoadEvent)
	},
	beforeUnmount() {
		window.removeEventListener('beforeunload', this.unLoadEvent)
	},
  methods: {
    doSearch: function() {
			if(this.inputQuery == '') {
				alert('검색어를 입력하세요')
				return
			}
			
      this.axios.get("/api/search", {
				params: {
					query: this.inputQuery
				}
			}).then((res) => {
        console.log(res)
				this.outputQuery = this.inputQuery
				this.inputQuery = ''
      })
      .catch((error) => {
        console.log(error)
      })
    },
    pressCheck: function(event) {
			console.log(event)
    },
		showDetail: function(val) {
			console.log(val)
		},
		unLoadEvent: function(event) {
			alert(123)

			event.preventDefault()
			event.returnValue = ''
		}
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
