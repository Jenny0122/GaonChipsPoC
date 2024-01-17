/* __placeholder__ */
//import moment from 'moment'
export default (await
    import ('vue')).defineComponent({
    name: 'BodyContents',
    data() {
        return {
            inputKeyword: '',
            outputKeyword: ''
        };
    },
    methods: {
        doSearch: function() {
            this.outputKeyword = this.inputKeyword;
        },
        pressCheck: function(event) {
            console.log(event);
        }
    }
});