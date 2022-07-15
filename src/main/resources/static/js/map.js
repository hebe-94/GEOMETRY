// (function (){
//
//     let map = new ol.Map({
//         target: 'map',
//         layers: [
//             new ol.layer.Tile({
//                 source: new ol.source.OSM()
//             })
//     //         source: new ol.source.XYZ({
//                //     url : 'http://xdworld.vworld.kr:8080/2d/Base/202002/{z}/{x}/{y}.png'
//              // })
//         ],
//         view: new ol.View({
//             center: ol.proj.fromLonLat([37.41, 8.82]),
//             // center: ol.proj.fromLonLat([37.41, 8.82]),
//             zoom: 15,
//             maxZoom: 20,
//             minZoom : 0,
//         })
//     });
//
//
//     map.on('click', function(e){
//         console.log(e)
//     })
//
//
//
//
//
//
// })();

// import 'ol/ol.css';
// import Map from 'ol/Map';
// import View from 'ol/View';
// import {ZoomSlider} from 'ol/control';
// import TileLayer from 'ol/layer/Tile';
// import OSM from 'ol/source/OSM';
// import {OverviewMap, defaults as defaultControls} from 'ol/control';


let overViewMapCtrl = new ol.control.OverviewMap({
    layers: [
        new ol.layer.Tile({
            source: new ol.source.XYZ({
                url: 'http://xdworld.vworld.kr:8080/2d/Base/201802/{z}/{x}/{y}.png'
            }),
        }) ],
    collapsed: true,
})

/**
 * Helper method for map-creation.
 *
 * @param {string} divId The id of the div for the map.
 * @return {Map} The map instance.
 */

let map = new ol.Map({
    layers: [new ol.layer.Tile({
        source: new ol.source.XYZ({
            url: 'http://xdworld.vworld.kr:8080/2d/Base/201802/{z}/{x}/{y}.png'
        })
    })],
    target: 'map',
    view: new ol.View({
        // projection:'EPSG:5181',
        center: [14377556.389982047, 4186024.063626864],
        zoom: 15,
        maxZoom: 20,
        minZoom : 0,
    }),
    controls:ol.control.defaults().extend([overViewMapCtrl])
});
let zoomslider = new ol.control.ZoomSlider();
map.addControl(zoomslider);


var exportOptions = {
    filter: function(element) {
        let className = element.className || '';
        return (
            className.indexOf('ol-control') === -1 ||
            className.indexOf('ol-legend') > -1 ||
            (className.indexOf('ol-attribution') > -1 &&
                className.indexOf('ol-uncollapsible'))
        );
    },
};

$("#saveImage").on("click", function(){
    // map.once('rendercomplete', function() {
    //     domtoimage
    //         .toJpeg(map.getTargetElement(), exportOptions)
    //         .then(function(dataURL) {
    //             let link = document.getElementById('image-download');
    //             link.href = dataURL;
    //             link.click();
    //         });
    // });
    // map.renderSync();
})

