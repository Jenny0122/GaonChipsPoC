<template>
    <div class="section_search02">
        <div class="cont_title">
            <div class="cont_title_l"></div>
            <h2 class="sc_title02">통합검색 <span class="sc_number">
            (총 {{ list.length }}건)
            </span></h2>
        </div>
        <ul class="dic" id="result_board">
            <li class="dic_100 dic_aside" v-for="p in list.slice(perPage * (currentPage - 1), perPage * (currentPage))" :key="p.name">
                <dl>
                    <dt class="title_area">
                        <a @click="download(p.file_name)" v-html="p.file_highlighted_name"></a>
                        <div class="title_info">
                            <!--<p class="title_area_name"><span>{{ p.file_name }}</span><span>인사팀</span></p>-->
                            <!--<span class="title_accuracy">[ 정확도 : 0.0 ]</span>-->

                        </div>
                    </dt>
                    <dd class="txt_inline">[등록일 : <span v-html="p.date"></span>]</dd>
                    <dd class="explain"><span v-html="p.file_content"></span></dd>
                </dl>
            </li>
        </ul>

        <div class="overflow-auto">
            <b-pagination
                            v-model="currentPage"
                            :total-rows="list.length"
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
// import { ref } from 'vue';

export default {
    name: "ResultAppr",
    props: {
        product: {
            type: Array,
            required: true
        }
    },
    data() {
        return {
            perPage: 5,
            currentPage: 1
        }
    },
    created() {
    },
    beforeUnmount() {},
    methods: {
        download: function(val) {
            this.axios
                .get("/api/download", {
                params: {
                    name: encodeURI(val),
                },
            })
                .then((res) => {
                    const name = res.headers["content-disposition"]
                                .split("filename=")[1]
                                .replace(/"/g, "");
                    const url = window.URL.createObjectURL(new Blob([res.data]));
                    const link = document.createElement("a");
                    link.href = url;
                    link.setAttribute("download", name);
                    link.style.cssText = "display:none";
                    document.body.appendChild(link);
                    link.click();
                    link.remove();
            })
                .catch((error) => {
                console.error(error)
            });
        }
    },
    computed: {
        list: function () {
            return this.product;
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
