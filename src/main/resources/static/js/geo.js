$("#makeTxt").on("click", function(){
    $.ajax({
        url : "/geo/getList.do",
        type : "GET"
    })
});