<template>
  <Body />
</template>

<script>
import Body from './components/Body.vue'

export default {
  name: 'App',
  components: {
    Body
  }
}
</script>

<style>
@charset "utf-8";
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 10px;
	
}

a:link, span {
	text-decoration: none;
	color: black;
}


/* 통합검색 css */

/*common -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/* 정해진 사이즈에서 멈춤 */
* html .fix_wrap,
* html .fix_conts {
    height: 1px;
}
.fix_wrap {
    min-width: 1225px;
    margin: 0 auto;
    _margin-left: 1225px; /*ie6*/
}
.fix_conts {
    position: relative;
    _margin-left: -1225px; /*ie6*/
}
.fix_wrap_1024 {
    min-width: 1007px;
    margin: 0 auto;
    _margin-left: 1007px; /*ie6*/
}
.fix_conts_1024 {
    position: relative;
    _margin-left: -1007px; /*ie6*/
}

/* 공통제어 */
/*html,body,div,li,dl,dt,dd,p,h1,h2,h3,h4,h5,h6,form{margin:0;padding:0;font:normal 12px dotum,'돋움',Apple SDGothic Neo,Apple-Gothic,맑은 고딕, Malgun Gothic,sans-serif; color:#222222;  line-height:1.5em; -webkit-text-size-adjust:none; }*/

html,
body,
div,
dl,
dt,
dd,
p,
form {
    margin: 0;
    padding: 0;
    font: 12px dotum, "돋움", Apple SDGothic Neo, Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
    color: #222222;
    line-height: 1.5em;
    -webkit-text-size-adjust: none;
}

/*span {line-height:normal;}*/
form {
    width: 100%;
    height: 100%;
}
select {
    font: normal 12px dotum, "돋움", Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
    color: #222222;
		box-sizing: border-box;
}
img {
    border: 0;
    vertical-align: middle;
}
a {
    font: normal 12px dotum, "돋움", Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
    color: #222222;
    text-decoration: none;
    line-height: 15px;
    -webkit-text-size-adjust: none;
}
a:hover {
    font: normal 12px dotum, "돋움", Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
    color: #000000;
    text-decoration: none;
    line-height: 15px;
    -webkit-text-size-adjust: none;
}
INPUT {
    font: normal 12px dotum, "돋움", Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
    color: #222222;
    line-height: 20px;
    height: 18px;
    height: 17px; /*ie7*/
    vertical-align: middle;
    border: 1px #d0d0d0 solid;
}

.con_in {
    margin: 10px 63px 40px 24px;
}

/* 레이아웃 */
.layout {
    position: relative;
    z-index: 20;
    width: 100%;
    margin: 0px;
    padding: 0px;
}
.container {
    float: left;
    position: relative;
    width: 100%;
    margin-left: -234px;
    z-index: 21;
}
.content_sf {
    width: auto;
    margin-left: 234px;
    margin-right: 23px;
}

/* 서브 컨텐츠 > 컨텐츠 레이아웃 */
.sub {
    width: auto;
    margin-left: 221px;
    width: 100%;
    float: left;
    position: relative;
    z-index: 21;
    background-color: #fff;
}
.sub_l {
    float: left;
    margin-left: -219px;
    padding-bottom: 30px;
    background-color: #f9f9f9;
    z-index: 2;
    border-left: solid 1px #d4d4d4;
    border-right: solid 1px #d4d4d4;
    width: 216px;
    display: inline;
}
.sub_c {
    float: left;
    background-color: #fff;
    width: 100%;
    z-index: 1;
}

/*common -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/*controls ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

@media all and (-ms-high-contrast: none) {
    .tree_label .img_align7 {
        padding-top: 4px;
    } /* IE10 */
    *::-ms-backdrop,
    .tree_label .img_align7 {
        padding-top: 4px;
    } /* IE11 */
}

/*controls ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/*default ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

.container {
    margin-left: -222px;
}

/*default ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/*content_wp ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/* 페이징 컨트롤 디자인 */
.paginate * {
    display: inline-block;
    border: 0;
}
.paginate {
    margin-top: 20px;
    padding: 0;
    height: auto;
    line-height: auto;
    text-align: center;
    font-size: 12px;
}
.paginate img {
    margin: 0;
    padding: 0;
}
.paginate a {
    display: inline-block;
    margin: 0 0 0 -1px;
    padding: 10px 0 0 0;
    width: 34px;
    height: 24px;
    line-height: 24px;
    text-align: center;
    background: #fff;
    border: 1px solid #e8e8e8;
    color: #808080;
    font: normal 12px arial, dotum, "돋움", Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
}
.paginate a:hover {
    display: inline-block;
    margin: 0 0 0 -1px;
    padding: 10px 0 0 0;
    width: 34px;
    height: 24px;
    line-height: 24px;
    text-align: center;
    background: #fff;
    border: 1px solid #e8e8e8;
    color: #808080;
    font: normal 12px arial, dotum, "돋움", Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
}
.paginate strong {
    display: inline-block;
    margin: 0 0 0 -1px;
    padding: 10px 0 0 0;
    width: 34px;
    height: 24px;
    line-height: 24px;
    text-align: center;
    background: #f47721;
    border: 1px solid #f47721;
    color: #fff;
    font: normal 12px arial, dotum, "돋움", Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
}
.paginate span a {
    display: inline-block;
    margin: 0 0 0 -1px;
    padding: 10px 0 0 0;
    width: 34px;
    height: 24px;
    line-height: 24px;
    text-align: center;
    background: #fff;
    border: 1px solid #e8e8e8;
    color: #808080;
    font: normal 12px arial, dotum, "돋움", Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
}
.paginate span a:hover {
    display: inline-block;
    margin: 0 0 0 -1px;
    padding: 10px 0 0 0;
    width: 34px;
    height: 24px;
    line-height: 24px;
    text-align: center;
    background: #f47721;
    border: 1px solid #f47721;
    color: #fff;
    font: normal 12px arial, dotum, "돋움", Apple-Gothic, 맑은 고딕, Malgun Gothic, sans-serif;
}

/* 페이징 컨트롤 중 Page Go 디자인 */
.paging table tbody td {
    height: 23px;
    line-height: 21px;
    padding: 5px 0 3px 0;
    padding: 5px 0 0 0 \9;
    border: 0;
    text-align: center;
}

/*content_wp ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/* Search Bar */
.header_search {
    height: 102px;
    width: 100%;
    background-color: #ffffff;
    border-bottom: 1px solid #f47721;
    text-align: center;
}
.white_window {
    margin-top: 30px;
    display: inline-block;
    height: 41px;
    margin-left: -161px;
    background-color: #fff;
}
.white_window_box {
    display: inline-block;
    height: 41px;
    background-color: #fff;
    border: 2px solid #f47721;
}
.white_window_select {
    float: left;
    appearance: none;
    -moz-appearance: none; /* Firefox */
    -webkit-appearance: none; /* Safari and Chrome */
    border: 0;
    padding: 0 0 0 5px;
    width: 100px;
    height: 37px;
    line-height: 35px;
    background: url(./assets/search_select.gif) no-repeat right top;
    outline: none;
}
.white_window_select::-ms-expand {
    display: none;
}
.window_select_option {
    display: block;
    height: 37px !important;
    line-height: 37px !important;
    padding: 10px 0 !important;
}
.white_input_text {
    float: left;
    display: inline-block;
    width: 355px;
    height: 35px;
    line-height: 35px;
    outline: none;
    border: 0;
}
.white_window_input {
    outline: none;
}
.white_window h1 {
    float: left;
    margin: 0;
    margin-right: 25px;
}
.white_window a.logo_header_search {
    float: left;
    width: 140px;
    height: 39px;
    background: url(./assets/logo.png) no-repeat left center;
    display: inline-block;
}
.white_window a {
    display: inline-block;
    width: 45px;
    height: 37px;
}
.search_button {
    display: inline-block;
    width: 45px;
    height: 37px;
    background: url(./assets/search_button.gif) no-repeat left top;
    position: relative;
}
.search_text {
    color: #0065cc;
    font-weight: bold;
}
.white_window_check {
    display: inline-block;
    margin-left: 10px;
}
.white_window_check input[type="checkbox"] {
    margin: -2px 5px 0 0;
}

/* lnb */
.sub_l_search01 {
    float: left;
    margin-left: -219px;
    padding-bottom: 30px;
    background-color: #fff;
    z-index: 2;
    border-left: solid 1px #d4d4d4;
    border-right: solid 1px #d4d4d4;
    width: 216px;
    display: inline; /* margin-top: 10px; */
    min-height: 780px;
    margin-top: 34px;
    height: 1450px;
}
.sub_l_search02 {
    float: left;
    margin-left: -219px;
    padding-bottom: 30px;
    background-color: #fff;
    z-index: 2;
    border-left: solid 1px #d4d4d4;
    border-right: solid 1px #d4d4d4;
    width: 216px;
    display: inline; /* margin-top: 10px; */
    min-height: 780px;
    margin-top: 34px;
}
.lt_search {
    background: url(./assets/ico_search.png) no-repeat;
    float: left;
    width: 217px;
    height: 51px;
    margin: 0 0 0 0;
    color: #fff;
    font-weight: bold;
    line-height: 18px;
    padding-top: 0px;
    background-color: #f47721;
    border-bottom: solid 1px #d4d4d4;
    background-position: 20px center;
}
.tree_search {
    width: 216px;
    overflow: auto;
}
.txt_ltit_search {
    font-size: 15px;
    font-family: 맑은 고딕, Malgun Gothic, 돋움, 굴림, Dotum, Gulim, Apple-Gothic, sans-serif;
    font-weight: bold;
    color: #ffffff;
    line-height: 49px;
    margin-left: 50px;
}
.search_list01 {
    width: 216px;
    height: 36px;
    border-bottom: solid 1px #d4d4d4;
}
.search_list02 {
    width: 216px;
    border-bottom: solid 1px #d4d4d4;
    padding: 9px 0 25px 0;
}
.list_text_on {
    position: relative;
    font-weight: bold;
    color: #f47721;
    display: block;
    padding: 11px 0 0 21px;
}
.list_text_on img {
}
.list_text_off {
    position: relative;
    font-weight: bold;
    display: block;
    padding: 11px 0 0 21px;
}
.list_text_off img {
    position: absolute;
    top: 16px;
    right: 22px;
}
.search_list02 a span {
    display: block;
    padding: 15px 0 0 21px;
}
.search_list02 a span img {
    padding: 0 5px 3px 0;
}

/* Content */
.content_sf {
    width: auto;
    margin-left: 234px;
    margin-right: 0 !important;
}
.section_search01 {
    clear: both;
    width: 100%;
    padding: 19px 0 19px 0;
    margin-top: 70px;
}
.section_search02 {
    clear: both;
    width: 100%;
    padding: 19px 0 19px 0;
    border-top: 1px solid #d4d4d4;
    margin-top: 5px;
}
.sc_title01 {
    position: relative;
    display: block;
    float: left;
    padding-bottom: 25px;
    margin-top: 25px;
    border-bottom: 1px solid #949494;
    width: 100%;
    z-index: 10;
}
.btn_detail_search {
    display: inline-block;
    height: 27px;
    line-height: 27px;
    background: url(./assets/btn_detail_search.gif) no-repeat left top;
    padding-left: 10px;
}
.btn_detail_search span {
    display: inline-block;
    height: 27px;
    line-height: 27px;
    background: url(./assets/btn_detail_search.gif) no-repeat right top;
    padding-right: 23px;
}
.search_radio_box {
    display: inline-block;
    margin-left: 20px;
}
.search_radio {
    margin-right: 15px;
}
.search_radio input[type="radio"] {
    margin: 0 5px;
}
.sc_number {
    font-size: 13px;
    color: #777;
    font-weight: lighter;
    padding-left: 5px;
}
.sc_title02 {
    display: inline-block;
    margin: 0;
    height: 41px;
    line-height: 41px;
    background: url(./assets/cont_title.gif) no-repeat 15px 13px;
    padding-left: 33px;
    font-size: 14px;
}
.ndic h2 {
    margin-bottom: 15px;
}
.ndic ul {
    padding-top: 1px;
}
.ndic .dic {
    margin-bottom: -11px;
}
.dic {
    clear: both;
    margin-left: -12px;
}
.dic li.dic_100 {
    overflow: hidden;
    clear: both;
    width: auto;
}
.dic li {
    clear: both;
    _width: 100%;
    margin: 20px 0 8px;
}
.dic li.dic_100 dl {
    overflow: hidden;
    _float: left;
    line-height: 18px;
    width: auto;
} /* overflow:visible;*/
.ndic .dic dl {
    overflow: visible;
    _width: 100%;
    zoom: 1;
}
.dic dl {
    font-size: 12px;
}
.title_area {
    position: relative;
}
.title_area:after {
    display: block;
    content: "";
    clear: both;
}
.title_area .hl {
    display: inline-block;
    background: #fff585;
}
.title_info {
    display: inline-block;
    float: right;
    padding-right: 10px;
}
.title_accuracy {
    display: inline-block;
    font-size: 13px;
    color: #777;
    vertical-align: middle;
}
.title_area_name {
    display: inline-block;
    font-size: 13px;
    color: #777;
    padding: 0 10px;
    vertical-align: middle;
}
.title_area_name span {
    position: relative;
    padding: 0 8px;
}
.title_area_name span:before {
    position: absolute;
    left: 0;
    top: 50%;
    display: block;
    content: "";
    width: 1px;
    height: 10px;
    margin-top: -5px;
    background-color: #777;
}
.title_area_name span:first-child:before {
    display: none;
}
.dic_board li {
    position: relative;
    margin-bottom: 15px;
    padding-left: 120px;
}
.dic_board li .dic_img {
    position: absolute;
    left: 0;
    top: 0;
    width: 100px;
    height: 80px;
}
.dic_aside dt {
    padding-top: 0 !important;
    font-size: 12px;
}
.txt_inline {
    padding-top: 3px;
    font-size: 13px;
    color: #777;
}
.dic dt {
    display: inline;
    float: left;
    padding: 2px 0 5px;
    font-weight: bold;
    color: #0470e2;
}
.dic li.dic_100 dl dt.title_area {
    display: inline-block;
    float: none !important;
    width: 100%;
    margin: 0 5px 0 0;
    padding: 0;
    font-weight: normal;
}
.dic li.dic_100 dl dt.title_area a {
    display: inline-block !important;
    float: left;
    border-bottom: 0 none;
    font-size: 15px;
    font-weight: bold;
    color: #222;
}
.dic li.dic_100 dl dt.title_area a:hover {
    display: inline-block !important;
    border-bottom: 0 none;
    text-decoration: underline;
    color: #0470e2;
}
.dic dt a {
    display: inline;
}
.section_more {
    overflow: hidden;
    clear: both;
    _width: 100%;
    padding: 0 3px 0 0;
    font-size: 12px;
    text-align: right;
}
.section_more a {
    float: right;
    padding: 3px 0 0 3px;
    text-decoration: underline;
}
.section_more a:hover {
    float: right;
    padding: 3px 0 0 3px;
    text-decoration: underline;
}
.explain {
    font-size: 13px;
    margin: 7px 0;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
}
.explain .hl {
    display: inline-block;
    background: #fff585;
}
.explain a {
    color: #777;
    text-decoration: underline;
}
.explain a:hover {
    color: #777;
    text-decoration: underline;
}
.dic_cate {
    display: block;
    padding-top: 5px;
    font-size: 13px;
}
.filein {
    margin: 0 0 3px 0;
}
.filein a {
    text-decoration: none;
    font-size: 13px;
    color: #777;
}

.section_search_box {
    position: relative;
    margin-right: 287px;
}
.section_search_right {
    position: absolute;
    top: 0;
    right: 0;
    width: 257px;
    margin-top: 97px;
    margin-right: -287px;
}
.search_text_box {
    width: 255px;
    border: 1px solid #d4d4d4;
    margin-bottom: 20px;
}
.search_text_title {
    height: 42px;
    line-height: 42px;
    background: url(./assets/search_text_title.gif) no-repeat 15px 14px;
    background-color: #f6f6f6;
    border-bottom: 1px solid #ebebeb;
    font-weight: bold;
    padding-left: 35px;
}
.search_text_list {
    list-style: none;
    margin: 15px 19px;
    padding: 0;
}
.search_text_list li {
    margin-bottom: 7px;
}
.search_text_list li a {
    display: inline-block;
    width: 100%;
    height: 16px;
    line-height: 16px;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
}
.search_text_list li img {
    margin-top: -3px;
    margin-right: 5px;
}

.cont_title {
    position: relative;
    height: 41px;
    border-top: 1px solid #d4d4d4;
    border-bottom: 1px solid #d4d4d4;
}
.cont_title_l {
    position: absolute;
    top: 0;
    left: 0;
    margin-top: -1px;
    display: inline-block;
    width: 3px;
    height: 43px;
    background: url(./assets/cont_title_l.gif) no-repeat left top;
}
.cont_title_r {
    position: absolute;
    top: 0;
    right: 0;
    margin-top: -1px;
    display: inline-block;
    width: 3px;
    height: 43px;
    background: url(./assets/cont_title_r.gif) no-repeat left top;
}

.search_detail_box {
    position: absolute;
    margin-top: -1px;
    width: 100%;
    background: #ffffff;
    border: 1px solid #939393;
    z-index: 20;
}
.search_date {
    clear: both;
    padding: 16px 18px 5px;
    display: block;
}
.search_date_txt {
    margin-right: 12px;
    display: inline-block;
    height: 26px;
    line-height: 26px;
    background: url(./assets/search_detail_txt.gif) no-repeat left top;
    padding-left: 10px;
}
.search_date_txt span {
    display: inline-block;
    height: 26px;
    line-height: 26px;
    background: url(./assets/search_detail_txt.gif) no-repeat right top;
    padding-right: 10px;
}
.search_date_select {
    display: inline-block;
}
.date_radio {
    display: inline-block;
    margin-right: 16px;
}
.date_radio input[type="radio"] {
    margin: -2px 5px 0 0;
}
.search_date_input {
    margin: 0 5px;
    width: 68px;
    height: 20px;
    line-height: 20px;
    background: #fefae1;
}
.search_area {
    clear: both;
    padding: 5px 18px 16px;
    display: block;
}
.search_area_txt {
    margin-right: 12px;
    display: inline-block;
    height: 26px;
    line-height: 26px;
    background: url(./assets/search_detail_txt.gif) no-repeat left top;
    padding-left: 10px;
}
.search_area_txt span {
    display: inline-block;
    height: 26px;
    line-height: 26px;
    background: url(./assets/search_detail_txt.gif) no-repeat right top;
    padding-right: 10px;
}
.search_checkbox_box {
    display: inline-block;
}
.search_checkbox {
    display: inline-block;
    margin-right: 16px;
}
.search_checkbox input[type="checkbox"] {
    margin: -2px 5px 0 0;
}
.search_input_box {
    display: inline-block;
    height: 20px;
    margin-left: 5px;
    padding-left: 20px;
    border-left: 1px solid #d4d4d4;
}
.search_input {
}
.search_input input[type="text"] {
    margin: -2px 15px 0 5px;
    width: 74px;
    height: 20px;
    line-height: 20px;
}

/* 달력 */
.LaryeCalenderPop {
    position: absolute;
    top: 22px;
    left: 5px;
    background-color: #ffffb3;
    layer-background-color: #ffffb3;
    overflow: visible;
}
.c_day {
    background: #fff;
    vertical-align: middle;
}
.t_day {
    background: #eff6fb;
    vertical-align: middle;
}
.s_day {
    background: #64a2dc;
    vertical-align: middle;
}
.w_day {
    height: 12px;
    background: #f0f0f0;
    vertical-align: middle;
    text-align: center;
    font-weight: bold;
}
.cal_body {
    width: 100%;
    margin: 3px 0 8px 0;
}
.cal_month {
    font-size: 12px;
}
.txt_sun {
    color: #ff0000;
}
.txt_sat {
    color: #748cd2;
}
.txt_today {
    color: #fff;
    font-weight: bold;
}
.ttday {
    font-size: 8pt;
    font-family: Tahoma;
    color: #fff;
    line-height: 9pt;
    text-align: center;
}
.stylecal {
    font-size: 8pt;
    font-family: Tahoma;
    color: #808080;
    line-height: 9pt;
    text-align: center;
}
.notmonth {
    font-size: 8pt;
    font-family: Tahoma;
    color: #ffffff;
    line-height: 9pt;
    text-align: center;
}
.futuremonth {
    font-size: 8pt;
    font-family: Tahoma;
    color: #cccccc;
    line-height: 9pt;
    text-align: center;
}
a.ttday:link {
    display: block;
    font-size: 8pt;
    font-family: Tahoma;
    color: #fff;
    line-height: 9pt;
    text-decoration: none;
    text-align: center;
}
a.ttday:visited {
    display: block;
    font-size: 8pt;
    font-family: Tahoma;
    color: #fff;
    line-height: 9pt;
    text-decoration: none;
    text-align: center;
}
a.ttday:hover {
    display: block;
    font-size: 8pt;
    font-family: Tahoma;
    color: #fff;
    line-height: 9pt;
    text-decoration: none;
    background-color: #64a2dc;
    text-align: center;
}
a.notmonth:link {
    display: block;
    font-size: 8pt;
    font-family: Tahoma;
    color: #c5c5c5;
    line-height: 9pt;
    text-decoration: none;
    text-align: center;
}
a.notmonth:visited {
    display: block;
    font-size: 8pt;
    font-family: Tahoma;
    color: #c5c5c5;
    line-height: 9pt;
    text-decoration: none;
    text-align: center;
}
a.notmonth:hover {
    display: block;
    font-size: 8pt;
    font-family: Tahoma;
    color: #808080;
    line-height: 9pt;
    text-decoration: none;
    background-color: #f2f2f2;
    text-align: center;
}
a.stylecal:link {
    display: block;
    font-size: 8pt;
    font-family: Tahoma;
    color: #808080;
    line-height: 9pt;
    text-decoration: none;
    text-align: center;
}
a.stylecal:visited {
    display: block;
    font-size: 8pt;
    font-family: Tahoma;
    color: #808080;
    line-height: 9pt;
    text-decoration: none;
    text-align: center;
}
a.stylecal:hover {
    display: block;
    font-size: 8pt;
    font-family: Tahoma;
    color: #808080;
    line-height: 9pt;
    text-decoration: none;
    background-color: #f2f2f2;
    text-align: center;
}
a.gotoday {
    font-size: 11px;
    text-decoration: none;
}
a.gotoday:hover {
    font-size: 11px;
    text-decoration: underline;
}
.row_off {
    background-color: #fff;
}
.row_on {
    background-color: #e8e8f3;
}
.row_off_a {
    background-color: #fff;
}
.row_on_a {
    background-color: #f2f2f2;
}
.trow_off {
    background-color: #eff6fb;
}
.trow_on {
    background-color: #eff6fb;
}
.trow_off_a {
    background-color: #eff6fb;
}
.trow_on_a {
    background-color: #eff6fb;
}
.srow_off {
    background-color: #64a2dc;
}
.srow_on {
    background-color: #64a2dc;
}
.srow_off_a {
    background-color: #64a2dc;
}
.srow_on_a {
    background-color: #64a2dc;
}
.ime_calender_mode {
    ime-mode: disabled;
    cursor: hand;
    background-color: #fefae1;
}
.img_align {
    margin: -4px 0 0 0;
}
.calendar_box {
    display: inline-block;
    position: relative;
}
.search_start {
    display: block;
    text-align: center;
    margin-bottom: 20px;
}
.search_start a {
    display: inline-block;
    height: 27px;
    line-height: 27px;
    background: url(./assets/btn_search_start.gif) no-repeat left top;
    padding-left: 10px;
}
.search_start a span {
    display: inline-block;
    height: 27px;
    line-height: 27px;
    background: url(./assets/btn_search_start.gif) no-repeat right top;
    padding-right: 10px;
    color: #fff;
    font-weight: bold;
}

/* 탑버튼 */
#MovTop {
    position: fixed;
    bottom: 20px;
    right: 20px;
    width: 50px;
    z-index: 30;
    transition: all 0.5s;
    background-color: #f47721;
    padding: 12px 12px 0 12px;
}
#MovTop > a {
    display: block;
}
#MovTop > a > s {
    display: block;
    margin: 0 auto;
    width: 14px;
    height: 8px;
    background: url("./assets/img_btnTop.png") no-repeat;
    background-size: 100% auto;
    transition: all 0.5s;
}
#MovTop > a > span {
    line-height: 33px;
    text-align: center;
    display: block;
    color: #fff;
    font-size: 12px;
    font-weight: bold;
    border-top: 1px rgba(255, 255, 255, 0.2) solid;
    margin-top: 12px;
    transition: all 0.5s;
}

/* 자동완성 */
.nuttop {
    position: relative;
    width: 406px;
    margin: 0 auto;
    padding-top: 20px;
    box-sizing: border-box;
}
.nuttop ul {
    position: relative;
    width: 406px;
    height: 40px;
    margin: 0;
    padding: 0;
    list-style: none;
    background-color: #f5f5f5;
    border-radius: 3px;
}
.nuttop li {
    float: left;
}
.auto {
    position: absolute;
    left: 0;
    top: -5px;
    width: 406px;
    height: 245px;
    margin: 0;
    text-align: left;
    border: 1px solid #ccc;
    background-color: #fff;
    box-sizing: border-box;
    overflow-x: hidden;
    overflow-y: auto;
    z-index: 99;
}
.auto .recomm {
    width: 100%;
    height: auto;
    padding: 3px 0;
    border-bottom: 1px solid #e0e0e0;
    background-color: #fff;
}
.auto .recomm li {
    clear: both;
    float: none;
    display: block;
    width: 100%;
    padding: 4px 8px;
    margin: 1px;
    text-align: left;
}
.auto .recomm li strong {
    color: #f47721;
    font-weight: bold;
}
.auto .recomm .endrecomm {
    float: left;
    background-color: #f2f6fc;
    border-top: 1px solid #cadef4;
}
.auto .close {
    position: relative;
    width: 394px;
    height: 11px;
    float: left;
    padding: 4px;
    font-size: 11px;
}
.auto .close a {
    color: #666;
    text-decoration: none;
}
.auto .close .help {
    position: absolute;
    width: 220px;
    height: 20px;
    top: 15px;
    left: 310px;
}
.nuttop .bigpopu {
    padding: 7px 0 7px 0;
}
.nuttop .bigpopu li {
    float: left;
    padding: 0 10px 0 0;
}
.nuttop .bigpopu a:link {
    color: #5980a2;
    text-decoration: none;
}
.nuttop .bigpopu a:hover {
    color: #5980a2;
    text-decoration: underline;
}
.nuttop .bigpopu a:visited {
    color: #5980a2;
    text-decoration: none;
}
.nuttop .dsa {
    position: absolute;
    width: 549px;
    height: 90px;
    border: 1px solid #7f9db9;
    background-color: #fff;
    top: 62px;
    left: 165px;
}
.nuttop .dsa .recomm {
    width: 247px;
    height: 20px;
    margin: 7px 0 0 17px;
}
.nuttop .dsa .recomm p {
    width: 50px;
    float: left;
}
.nuttop .dsa .recomm input {
    width: 190px;
    height: 14px;
    padding: 2px;
    border: 1px solid #5f768b;
    background-color: #f9f9f9;
}
.nuttop .dsa .close {
    width: 517px;
    height: 20px;
    margin: 7px 0 0 10px;
    text-align: right;
}
.resultall {
    color: #94959a;
}
.resultall span.tx_keyword {
    font-weight: bold;
    color: #000;
}
.resultall span.tx_cnt {
    font-weight: bold;
    color: #319fc4;
}
.ttxt {
    font-size: 18px;
    font-weight: bold;
}
.nuttop ul.auto_user {
    clear: both;
    width: 300px;
    height: auto;
    border-bottom: 0;
    border-radius: 0;
    background-color: #fff;
}
.auto_user li {
    float: none;
}
.auto_user a.auto_user_link {
    position: relative;
    display: block;
    padding: 10px 10px 10px 80px;
    height: 100px;
    box-sizing: border-box;
}
.auto_user a.auto_user_link .auto_user_img {
    position: absolute;
    top: 10px;
    left: 10px;
    width: 60px;
    height: 80px;
}
.auto_user a.auto_user_link .auto_user_img img {
    width: 60px;
}
.auto_user a.auto_user_link .tx_name {
    display: block;
    color: #000;
    font-weight: bold;
}
.auto_user a.auto_user_link .tx_key {
    color: #f47721;
}
.auto_user a.auto_user_link .tx_team {
    display: block;
    font-size: 11px;
    color: #999;
}
.auto_user a.auto_user_link .tx_tel {
    display: block;
    font-size: 11px;
    color: #999;
}
.auto_user a.auto_user_link .tx_phone {
    display: block;
    font-size: 11px;
    color: #999;
}
.auto_user a.auto_user_link .tx_mail {
    display: block;
    font-size: 11px;
    color: #999;
}
.auto_text {
    clear: both;
    display: block;
    padding: 10px;
    box-sizing: border-box;
    border-top: 1px solid #e0e0e0;
    border-bottom: 1px solid #e0e0e0;
}
.auto_text strong {
    font-weight: bold;
    color: #f47721;
}
.auto_btn_wrap {
    clear: both;
    display: block;
    padding: 0 10px;
    height: 30px;
    line-height: 30px;
    box-sizing: border-box;
    text-align: right;
}
.auto_btn {
    height: 30px;
    line-height: 30px !important;
    display: inline-block;
    color: #666 !important;
}

.section_search_right {
    display: none;
}
.section_search_box {
    margin-right: 0;
}
</style>
