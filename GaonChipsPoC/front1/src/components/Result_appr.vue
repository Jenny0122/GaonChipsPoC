<template>
    <div v-if="collection.equals('ALL') || collection.equals(thisCollection)">
        <div class="section_search01" v-if="thisTotalCount >= 0" v-bind:class="collection == 'ALL' ? 'section_search02' : 'section_search01'">
            <div class="cont_title">
                <h2 class="sc_title02">
                    {{ wnsearch.getCollectionKorName(thisCollection) }} <span class="sc_number"> (총 {{ numberFormat(thisTotalCount) }}건) </span>
                </h2>
                <div class="search_radio_box">
                    <span class="search_radio"><input type="radio" name="search_radio02" id="apprType_appr" value="appr" v-model="apprType">완료문서</span>
                    <span class="search_radio"><input type="radio" name="search_radio02" id="apprType_mig" value="mig" v-model="apprType">이관문서</span>
                </div>
            </div>

            <div class="search_n_result_wrap" id="result_<%=thisCollection%>" v-if="thisTotalCount < 1">
                <p class="search_n_result_txt">
                    <span class="search_n_result_img"></span> <strong class="tx_keyword">'{{ outputQuery }}'</strong>에 대한 전자결재 검색 결과가 없습니다.<br /><span class="search_n_result_txt2">다른 검색어로 검색해 보시기 바랍니다.</span>
                </p>
            </div>

            <ul class="dic" id="result_<%=thisCollection%>" v-if="thisTotalCount >= 1">
                <li class="dic_100 dic_aside">
                    <dl>
                        <dt class="title_area" data-docid="<%=PROCESS_ID%>">
                            <a :href="DOC_URL">{{ SUBJECT }}</a>
                            <div class="title_info">
                                <p class="title_area_name">
                                    <span>{{ creatornameArr[0] }}</span
                                    ><span v-if="CREATOR_DEPT.length() > 0">{{ creatordepArr[0] }}</span>
                                </p>
                                <span class="title_accuracy">[ 정확도 : {{ (RANK * 1) / 100 }} ]</span>
                            </div>
                        </dt>
                        <dd class="txt_inline">[기안일시: {{ INITIATED_DATE }}] [완료일시: {{ COMPLETED_DATE }}]</dd>
                        <!--  <dd class="explain"><%=BODYCONTENTS%></dd>-->
                        <dd class="filein" v-if="fileNameArr.length > 0" v-for="fileName in fileNameArr">
                            <a>첨부파일 : {{ fileName }}</a>
                        </dd>
                    </dl>
                </li>
            </ul>

            <div v-if="collection.equals('ALL') && thisTotalCount > TOTALVIEWCOUNT_MAP.get(thisCollection)" class="section_more" id="moreresult_<%=thisCollection%>"><a href="#none" onClick="javascript:doCollection('<%=thisCollection%>');"> 검색 결과 더보기 </a></div>
        </div>
    </div>
</template>

<script>
export default {
    name: "ResultAppr",
    data() {
        return {};
    },
    mounted() {},
    beforeUnmount() {},
    methods: {},
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
