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