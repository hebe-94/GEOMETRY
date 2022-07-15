<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Jsp page sample</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.1.1/css/ol.css" type="text/css">
    <script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.14.1/build/ol.js"></script>
    <script src="/webjars/jquery/dist/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="css/map.css">


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
            <td>지도로 이동하기</td>
            <td><input id="moveToMap" type="button" value="지도로 이동하기"></td>
        </tr>
        </tbody>

    </table></div>
</body>

<script type="text/javascript" src="js/map.js"></script>
<script type="text/javascript" src="/js/geo.js"></script>

</html>

