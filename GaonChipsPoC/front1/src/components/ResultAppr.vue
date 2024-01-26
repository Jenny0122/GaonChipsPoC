<template>
    <div><!--<div v-if="collection=='ALL' || collection==thisCollection">-->
        <div class="section_search01 section_search02">
            <div class="cont_title">
                <h2 class="sc_title02">
                    {{ outputQuery }} <span class="sc_number"> (총 {{ product.length }}건) </span>
                </h2>
                <div class="search_radio_box">
                    <span class="search_radio"><input type="radio" name="search_radio02" id="apprType_appr" value="appr" v-model="apprType">완료문서</span>
                    <span class="search_radio"><input type="radio" name="search_radio02" id="apprType_mig" value="mig" v-model="apprType">이관문서</span>
                </div>
            </div>

            <div class="search_n_result_wrap" id="result_appr">
                <p class="search_n_result_txt">
                    <span class="search_n_result_img"></span> <strong class="tx_keyword">' {{ outputQuery }} '</strong>에 대한 전자결재 검색 결과가 없습니다.<br /><span class="search_n_result_txt2">다른 검색어로 검색해 보시기 바랍니다.</span>
                </p>
            </div>

            <ul class="dic" id="result_appr">
                <li class="dic_100 dic_aside" v-for="p in product" :key="p.code">
                    <dl>
                        <dt class="title_area">
                            <span>{{ p.name }}</span>
                            <div class="title_info">
                                <p class="title_area_name">
                                </p>
                                <span class="title_accuracy">[ 정확도 : {{ (1 * 1) / 100 }} ]</span>
                            </div>
                        </dt>
                        <dd class="txt_inline">[기안일시: {{p.initiateddate}} ] [완료일시: COMPLETED_DATE ]</dd>
                        <!--  <dd class="explain"><%=BODYCONTENTS%></dd>-->
                        <!--
                        <dd class="filein" v-if="fileNameArr.length > 0" v-for="fileName in fileNameArr">
                            <a>첨부파일 : {{ fileName }}</a>
                        </dd>
                        -->
                    </dl>
                </li>
            </ul>

            <div class="section_more" id="moreresult_appr"><a href="#none" onClick="javascript:doCollection('appr');"> 검색 결과 더보기 </a></div>
        </div>
    </div>
</template>

<script>
export default {
    name: "ResultAppr",
    props: {
        outputQuery: String,
        product: Array
    },
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
