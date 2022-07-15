(function (){

    let map = new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()
            })
    //         source: new ol.source.XYZ({
               //     url : 'http://xdworld.vworld.kr:8080/2d/Base/202002/{z}/{x}/{y}.png'
             // })
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([37.41, 8.82]),
            // center: ol.proj.fromLonLat([37.41, 8.82]),
            zoom: 15,
            maxZoom: 20,
            minZoom : 0,
        })
    });

    map.on('click', function(e){
        console.log(e)
    })

    console.log($("#map"))

})();


