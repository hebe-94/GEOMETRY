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
        <tr>
            <td>지도 이미지로 저장하기</td>
            <td><input id="saveImage" type="button" value="현재 지도 이미지 다운">
                <a id="export-png" class="btn btn-default"><i class="fa fa-download"></i> Download PNG</a>
                <a id="image-download" download="map.png"></a>
            </td>
        </tr>
        </tbody>

    </table></div>
</body>

<script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.14.1/build/ol.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.14.1/css/ol.css">

<script src="/webjars/jquery/dist/jquery.min.js"></script>

<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="css/map.css">
<script type="text/javascript" src="js/map.js"></script>
<script type="text/javascript" src="/js/geo.js"></script>

</html>

