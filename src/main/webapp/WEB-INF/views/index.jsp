<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Jsp page sample</title>
</head>

<body>
    <div><h2>실습 과제!</h2></div>

    <div id="map" class="maps" style="float: right"></div>

    <div style="float: left"><table id="workTable">
        <thead>
        <tr>
            <td>내용</td>
            <td>동작</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>TXT 파일 만들기</td>
            <td><input id="makeTxt" type="button" value="TXT 파일"></td>
        </tr>
        <tr>
            <td>EXCEL 파일 만들기</td>
            <td><input id="makeExcel" type="button" value="Excel 파일"></td>
        </tr>
        <tr>
            <td>Point레이어 버퍼 연산</td>
            <td><input id="makeBufferExcel" type="button" value="Excel 파일"></td>
        </tr>
<%--        <tr>--%>
<%--            <td>지도 이미지로 저장하기</td>--%>
<%--            <td><input id="saveImage" type="button" value="현재 지도 이미지 다운">--%>
<%--                <a id="export-png" class="btn btn-default"><i class="fa fa-download"></i> Download PNG</a>--%>
<%--                <a id="image-download" download="map.png"></a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>도형 그리기</td>--%>
<%--            <td>--%>
<%--                <form class="form-inline">--%>
<%--                    <select id="type">--%>
<%--                        <option value="Point">Point</option>--%>
<%--                        <option value="LineString">LineString</option>--%>
<%--                        <option value="Polygon">Polygon</option>--%>
<%--                        <option value="Circle">Circle</option>--%>
<%--                    </select>--%>
<%--                </form>--%>
<%--            </td>--%>
<%--        </tr>--%>
        </tbody>

    </table></div>
</body>

<script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.14.1/build/ol.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.14.1/css/ol.css">
<!-- Pointer events polyfill for old browsers, see https://caniuse.com/#feat=pointer -->
<script src="https://unpkg.com/elm-pep@1.0.6/dist/elm-pep.js"></script>
<!-- The lines below are only needed for old environments like Internet Explorer and Android 4.x -->
<script src="https://cdn.polyfill.io/v3/polyfill.min.js?features=fetch,requestAnimationFrame,Element.prototype.classList,TextDecoder"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/3.18.3/minified.js"></script>

<script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
<script src="https://openlayers.org/en/v4.6.5/build/ol.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/1.3.3/FileSaver.min.js"></script>



<script src="/webjars/jquery/dist/jquery.min.js"></script>

<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="css/map.css">
<script type="text/javascript" src="js/map.js"></script>
<script type="text/javascript" src="/js/geo.js"></script>
<%--<script type="text/javascript" src="/js/posts.js"></script>--%>

</html>


<%--
npm, script, download의 차이
rendering이 되지 않는데 문제 확인
대략 흐름을 알겠는데  (map -> layer,source -> view -> 필요 추가 controls 순으로 설정) ->
map : 지도 만들기 (base 깔기)
layer, source : 지도상에 올라가는 각 레이어  -> 소스에 따라 레이어의 특성이 결정된다. (필요한 스타일,타입으로 필요한 기능을 담은 layer를 하나씩 추가가view :
        어떻게 시각화 할지 설정
        좌표계 설정 => projection:'EPSG:5181',
        지도의 첫화면이 어디인지
controls : overView와 같은 부수적인 기능들
--%>
