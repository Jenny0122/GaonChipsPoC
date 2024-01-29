<template>
    <div class="section_search02">
        <div class="cont_title">
            <div class="cont_title_l"></div>
            <h2 class="sc_title02">게시판 <span class="sc_number">
            (총 {{ product.length }}건)
            </span></h2>
        </div>
        
        <ul class="dic" id="result_board">
            <li class="dic_100 dic_aside" v-for="p in data.slice(perPage * (currentPage - 1), perPage * (currentPage))" :key="p.name">
                <dl>
                    <dt class="title_area">
                        <a v-html="p.file_name"></a>
                        <div class="title_info">
                            <!--<p class="title_area_name"><span>{{ p.file_name }}</span><span>인사팀</span></p>-->
                            <!--<span class="title_accuracy">[ 정확도 : 0.0 ]</span>-->

                    </div></dt>
                    <dd class="txt_inline">[등록일 : {{ p.date }}]</dd>
                    <dt class="explain">{{ p.file_content }}</dt>
                </dl>
            </li>
        </ul>

        <div class="overflow-auto">
            <b-pagination
                            v-model="currentPage"
                            :total-rows="rows"
                            :per-page="perPage"
                            aria-controls="result_board"
                            align="center"
                            size="lg"
                            limit="7"
                            variant="primary"
                            pills
        first-number
        last-number
                            >
            </b-pagination>
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
        return {
            data: [],
            perPage: 5,
            currentPage: 1
        }
    },
    created() {
        this.data = this.product

        for(var i in this.data) {            
            const index = this.data[i].file_name.search(this.outputQuery)
            
            if(index > 0)
                this.data[i].file_name = this.data[i].file_name.substring(0, index)
                                        + '<strong class="hl">'+ this.outputQuery + '</strong>'
                                        + this.data[i].file_name.substring(index + this.outputQuery.length)
        }
    },
    beforeUnmount() {},
    methods: {},
    computed: {
        rows: function () {
            return this.data.length
        }
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
b-pagination.active {
  background-color: red;
}
</style>
