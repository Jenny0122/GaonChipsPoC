<template>
    <b-overlay :show="show" rounded="lg" no-wrap>
    <div class="wrap">
        
            <div class="header_wrap">
                <div class="fix_wrap">
                    <div class="fix_conts">
                        <!-- Header 시작 -->
                        <div class="header_search">
                            <div class="white_window">
                                <h1 class="h_search">
                                    <a href="/" class="logo_header_search"></a>
                                </h1>
                                <span class="white_window_box">
                                
                                    <!--<select style="" class="white_window_select" id="searchSelect">
                                        <option value="ALL" <%=searchField.indexOf("ALL") > -1 ? "selected" : ""%>>전체</option>
                        <option value="SUBJECT" <%=searchField.indexOf("SUBJECT") > -1 ? "selected" : ""%>>제목</option>
                        <option value="BODYCONTEXTS" <%=searchField.indexOf("BODYCONTENTS") > -1 ? "selected" : ""%>>내용</option>
                        <option value="CREATOR_NAME" <%=searchField.indexOf("CREATOR_NAME") > -1 ? "selected" : ""%>>작성자</option>
                    </select>
                -->
                                    <input class="white_input_text" type="text" name="query" id="query" v-model.trim="inputQuery" @keyup.enter="doSearch" autocomplete="off" style="padding: 10px; ime-mode: auto" />
                                    <a href="#" @click="doSearch" title="검색"><span class="search_button"></span></a>
                                </span>
                            </div>
                            <!--<div class="white_window_check"><input type="checkbox" name="reChk" id="reChk" @click="checkReSearch" />결과내 재검색</div>-->

                            <div id="ark"></div>
                        </div>
                        <!-- Header 끝 -->
                        <!-- 컨텐츠영역시작 -->
                        <div class="layout">
                            <div class="container">
                                <div class="content_sf">
                                    <div class="sub" id="pTag">

    <!--
                                        <div class="sub_l_search01">
                                            
                                            <h2 class="lt_search">
                                                <span class="txt_ltit_search">통합검색</span>
                                            </h2>
                                            
                                            <div id="divOpenBoardLevel"></div>
                                            <div class="tree_search">
                                                <div class="search_list01">
                                                    <a href="#" class="search_list_close">
                                                        <span v-bind:class="collection == 'ALL' ? 'list_text_on' : 'list_text_off'">전체</span>
                                                    </a>
                                                </div>
                                                <div class="search_list01">
                                                    <a href="#" class="search_list_open">
                                                        <span class="list_text_off">시스템구분</span>
                                                    </a>
                                                </div>
                                                <div class="search_list02">
                                                    <a href="#" @click="doCollection('<%=element[0] %>')"><span class=<%=collection.equals(element[0].toString()) ? "list_text_on" : "" %>><img src="../assets/ico_bbar.gif"><%=systemName%> (<%=thisTotalCount %>)</span></a>
                                                </div>
                                            </div>
                                        </div>
                                    -->
                                        <!-- 트리 끝 -->
                                        <p class="space"></p>
                                        <!-- lnb 끝 -->

                                        <div style="padding: 0 5%" class="sub_c" id="cTag">
                                            <div class="con_in">
                                                <div class="sc_title01" v-if="outputQuery != ''">
                                                    검색어 <span class="search_text">'{{ outputQuery }}'</span>에 대하여 <strong>[총 {{ product.length }}건]</strong> 통합검색 결과입니다. <span style="font-weight: bold; color: gray;">({{ executeTime }}s)</span>
                                                    <!--
                                                    <a @click="fnShow('DivLayer100')" class="btn_detail_search">
                                                        <span>상세검색</span>
                                                    </a>
                                                    <div class="search_radio_box">
                                                        <span class="search_radio"> <input type="radio" name="search_radio01" value="RANK" @click="doSorting(this.value);" v-model="sort" /> 정확도순 </span>
                                                        <span class="search_radio"> <input type="radio" name="search_radio01" value="DATE" @click="doSorting(this.value);" v-model="sort" /> 날짜순 </span>
                                                        <span class="search_radio"> <input type="radio" name="search_radio01" value="SUBJECT" @click="doSorting(this.value);" v-model="sort" /> 제목순 </span>
                                                    </div>
                                                    -->

                                                    <div class="search_detail_box" id="DivLayer100" style="display: none">
                                                        <div class="search_date">
                                                            <div class="search_date_txt">
                                                                <span>검색기간</span>
                                                            </div>
                                                            <div class="search_date_select">
                                                                <span class="date_radio"><input type="radio" value="A" v-model="range" @click="setDate(this.value)" name="date_radio01" />전체 </span>
                                                                <span class="date_radio"><input type="radio" value="D" v-model="range" @click="setDate(this.value)" name="date_radio01" />1일 </span>
                                                                <span class="date_radio"><input type="radio" value="W" v-model="range" @click="setDate(this.value)" name="date_radio01" />1주 </span>
                                                                <span class="date_radio"><input type="radio" value="M" v-model="range" @click="setDate(this.value)" name="date_radio01" />1개월 </span>

                                                                <span class="date_radio">
                                                                    <!--<input type="radio" <%=range.equals("undefined") ? "checked" : ""%> @click="changeDatepickerValue('enable');" name="date_radio01" /> 사용자정의 -->
                                                                    <span class="calendar_box">
                                                                        <input type="text" name="startDate" id="startDate" v-model="startDate" readonly="true" class="search_date_input" />
                                                                    </span>
                                                                    <span class="calendar_box">
                                                                        <input type="text" name="endDate" id="endDate" v-model="endDate" readonly="true" class="search_date_input" />
                                                                    </span>
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="search_area">
                                                            <div class="search_area_txt">
                                                                <span>검색범위</span>
                                                            </div>
                                                            <div class="search_checkbox_box">
                                                                <!--<span class="search_checkbox">
                                                                                                                                <input type="checkbox" <%=searchField.indexOf("ALL") > -1 ? "checked" : ""%> value="ALL" id="checkAll"/>전체 </span>
                                                                                                                                <span class="search_checkbox"><input type="checkbox" <%=searchField.indexOf("SUBJECT") > -1 ? "checked" : ""%> name="searchFields" value="SUBJECT"/>제목 </span>
                                                                                                                                <span class="search_checkbox"><input type="checkbox" <%=searchField.indexOf("BODYCONTENTS") > -1 ? "checked" : ""%> name="searchFields" value="BODYCONTENTS"/>본문 </span>
                                                                                                                                <span class="search_checkbox"><input type="checkbox" <%=searchField.indexOf("CREATOR_NAME") > -1 ? "checked" : ""%> name="searchFields" value="CREATOR_NAME"/>작성자 </span>
                                    -->
                                                                <div class="search_input_box">
                                                                    <span class="search_input">부서명<input type="text" name="prefix_input" id="prefix_dep" /></span>
                                                                    <span class="search_input">작성자<input type="text" name="prefix_input" id="prefix_writer" /></span>
                                                                    <span class="search_input">수신/참조/결재자 <input type="text" name="prefix_input" id="prefix_etc"/></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="search_start">
                                                            <a href="#" @click="doSearch" title="상세검색">
                                                                <span>검색</span>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <ResultAppr v-if="outputQuery != ''"  :product="product" :outputQuery="outputQuery"/>
                                            <div class="paginate"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 컨텐츠영역끝 -->
            </div>
        
    </div>
    <!-- TOP버튼 -->
    <!--
    <div id="MovTop" class="onlPsc">
        <a href="javascript:;">
            <s></s>
            <span>TOP</span>
        </a>
    </div>
    -->
    </b-overlay>
</template>

<script>
//import { relativeTimeThreshold } from 'moment';
import ResultAppr from './ResultAppr.vue';

export default {
    name: "BodyContents",
    data() {
        return {
            inputQuery: "",
            outputQuery: "",
            totalCount: 0,
            startCount: 0,
            sort: "DATE",
            categoryQueryW: "",
            categoryQueryD: "",
            collectionQueryW: "",
            collectionQueryD: "",
            collection: "ALL",
            range: ["A"],
            searchField: "ALL",
            prefix: "",
            filter: "",
            reQuery: 0,
            realQuery: "",
            UR_CODE: "",
            DN_CODE: "",
            DEPT_ID: "",
            apprType: "appr",
            startDate: "2000-01-01",
            endDate: "",
            doctype: "",
            product: [],
            executeTime: 0,
            show: false
        };
    },
    mounted() {
        //window.addEventListener('beforeunload', this.unLoadEvent)
    },
    beforeUnmount() {
        //window.removeEventListener('beforeunload', this.unLoadEvent)
    },
    methods: {
        doSearch: function () {
            if (this.inputQuery == "") {
                alert("검색어를 입력하세요");
                return;
            }

            let start = new Date()

            this.show = true
            this.axios
                .get("/api/search", {
                params: {
                    query: this.inputQuery,
                },
            })
                .then((res) => {
                this.outputQuery = this.inputQuery
                this.inputQuery = ""
                this.product = res.data

                console.log(this.product)

                for(var i in this.product) {
                    this.product[i].file_highlighted_name = this.product[i].file_name.replaceAll(this.outputQuery, '<strong class="hl">'+ this.outputQuery + '</strong>')
                    this.product[i].file_content = this.product[i].file_content.replaceAll(this.outputQuery, '<strong class="hl">'+ this.outputQuery + '</strong>')
                    this.product[i].date = this.product[i].date.replaceAll(this.outputQuery, '<strong class="hl">'+ this.outputQuery + '</strong>')
                }

                this.show = false
                
                let end = new Date()

                this.executeTime = (end - start) / 1000

                console.log('실행시간: ' + this.executeTime + "s")
            })
                .catch((error) => {
                console.error(error);
            });
        },
        showDetail: function (val) {
            console.log(val);
        },
        unLoadEvent: function (event) {
            event.preventDefault();
            event.returnValue = "";
        },
        doSorting: function (val) {
            console.log(val);
        },
        fnShow: function (val) {
            console.log(val);
        }
    },
    components: { ResultAppr }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

</style>
