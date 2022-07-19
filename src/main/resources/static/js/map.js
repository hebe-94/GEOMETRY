/* xdworld */
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

/*
* overView 설정
* */
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

//???? 레스터란?
const raster = new ol.layer.Tile({
    source: new ol.source.OSM(),
});
// 레이어에 하나씩 속하게 되는 레이어가 어떤것이 될지 설정
// 실제로 일하는 클래스
const source = new ol.source.Vector();

// 지도상에 올라가는 각 레이어  -> 소스에 따라 레이어의 특성이 결정된다.
const vector = new ol.layer.Vector({
    source: source,
    // 레이어의 스타일을 설정
    style: new ol.style.Style({
        // 도형이 그려이면 어떠한 색으로 채울 것인지
        fill: new ol.style.Fill({
            color: 'rgba(255, 255, 255, 0.2)',
        }),
        // 마우스 포인터에 대한 속성
        stroke: new ol.style.Stroke({
            color: '#5555ff',
            width: 2,
        }),
        // 도형에 대한 속성
        image: new ol.style.Circle({
            radius: 7,
            fill: new ol.style.Fill({
                color: '#0000ff',
            }),
        }),
    }),
});

// Limit multi-world panning to one world east and west of the real world.
// Geometry coordinates have to be within that range.

// ol.proj.get('EPSG:3857') : 지정된 코드에 대한 projection 개체를 가져온다.
// ~.getExtent (Projection.getExtent) : 개체 투영에 대한 유효성 범위를 가져온다. -> projection : 좌표계
// ~getExtent (Geometry.getExtent) : 숫자를 가지고 있는 배열( [minx, miny, maxx, maxy] )을 반환
//
const extent = ol.proj.get('EPSG:3857').getExtent().slice();
extent[0] += extent[0];
extent[2] += extent[2];

// 지도 생성
let map = new ol.Map({
    // 지도에 올라갈 layer를 설정
    // vworld 배경지도로 올린다.
    layers: [new ol.layer.Tile({
        source: new ol.source.XYZ({
            url: 'http://xdworld.vworld.kr:8080/2d/Base/201802/{z}/{x}/{y}.png'
        })
    })],
    // html에서 'map'이라는 아이디를 가지고 있는 요소를 타겟
    target: 'map',
    // 어떻게 시각화 할지 설정
    view: new ol.View({
        // 좌표계 설정
        // projection:'EPSG:5181',
        // 지도의 첫화면이 어디인지
        center: [14377556.389982047, 4186024.063626864],
        // 줌 설정
        zoom: 15,
        maxZoom: 20,
        minZoom : 0,
    }),
    // 추가 기능? 지도를 컨트롤 할 수 있는 기능을 추가
    // 지도에 포함된 컨트롤 집합, 설정하지 않는다면 default로 각각의 컨트롤 인스턴스를 포함한 컬렉션을 반환한다.
    controls:ol.control.defaults().extend([overViewMapCtrl])
});
// 줌을 표현하는 slider 추가
let zoomslider = new ol.control.ZoomSlider();
// controls에 추가 되지 않았다면 map의 객체에서 addControl로 개체를 추가 할 수 있다.
map.addControl(zoomslider);




// /*
//     *
//     * 도형그리기기
//     *
//     *
//      */
//
// const modify = new ol.interaction.Modify({source: source});
// map.addInteraction(modify);
//
// let draw, snap; // global so we can remove them later
// const typeSelect = document.getElementById('type');
//
// function addInteractions() {
//     draw = new ol.interaction.Draw({
//         source: source,
//         type: typeSelect.value,
//     });
//     map.addInteraction(draw);
//     snap = new ol.interaction.Snap({source: source});
//     map.addInteraction(snap);
// }
//
// /**
//  * Handle change event.
//  */
// typeSelect.onchange = function () {
//     map.removeInteraction(draw);
//     map.removeInteraction(snap);
//     addInteractions();
// };
//
// addInteractions();
