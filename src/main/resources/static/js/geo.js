$("#makeTxt").on("click", function(){
    $.ajax({
        url : "/geo/makeText.do",
        type : "GET"
    })
});

$("#makeExcel").on("click", function(){
    $.ajax({
        url : "/geo/makeExcel.do",
        type : "GET"
    })
});
$("#makeBufferExcel").on("click", function(){
    $.ajax({
        url : "/geo/makeBufferExcel.do",
        type : "GET"
    })
});