<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>여기내GYM</title>
    <link rel="stylesheet" href="/css/main.css" />
    <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c5dd04594745b1c49f203dcc785c3dc5"
    ></script>
    <%@ include file="/common/bootstrap_common.jsp"%>
    <script>
        function getLoc() {
            //insert here
        }
    </script>
  </head>  
  <body>
    <!--==============================================================  -->
    <%@ include file="/include/gym_header.jsp"%>
    <!--==============================================================  -->
    <!--==============================================================  -->
    <div class="container">
      <div class="main_header"></div>
      <div class="main">
        <div>이벤트존</div>
        <hr style="height: 2px" />
        <div class="mapwrap">
          <div class="map" id="map" style="width: 500px; height: 400px">
            여기
          </div>
          <script type="text/javascript">
            const container = document.getElementById("map");
            const positions = [
              {
                content: '<div style="padding:5px;">구디아카데미</div>',
                latlng: new kakao.maps.LatLng(37.476773, 126.879959),
              },
            ];
            const options = {
              center: positions[0].latlng,
              level: 4,
            };
            const map = new kakao.maps.Map(container, options);
          </script>

          <input class="btnGeoloc" type="button" value="현재위치" onclick="geoLoc()">

        </div>
        <hr style="height: 2px" />
        <table class="table" style="minwidth: 700px">
          <tbody style="border: 1px solid lightgray">
            <tr>
              <td style="borderright: 1px solid lightgray">주소</td>
              <td>
                서울특별시 금천구 가산디지털2로 95 KM타워 3층 (T: 02-818-7950)
              </td>
            </tr>
            <tr>
              <td style="borderright: 1px solid lightgray">버스</td>
              <td>
                디지털3단지 사거리 정류장<br />
                지선 5536/5714 간선 503/504 일반 21
              </td>
            </tr>
            <tr>
              <td style="borderright: 1px solid lightgray">지하철</td>
              <td>지하철 1, 7호선 가산디지털단지역 5번출구 200m</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="footer"></div>
    </div>
    <!--================================================================  -->
    <!--================================================================  -->
    <%@ include file="/include/gym_footer.jsp"%>
    <!--================================================================  -->
  </body>
</html>
