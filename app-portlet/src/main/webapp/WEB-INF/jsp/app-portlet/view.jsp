<%@ include file="init.jsp" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div ng-app="myApp">
    <%--<div ng-controller="userInfo">--%>
        <%--<button ng-click="getUserInfo()">Get user info</button>--%>
        <%--&lt;%&ndash;<p>User's Name: <input ng-model="userName" type="text" /></p>&ndash;%&gt;--%>
        <%--<p>User's Name: {{userName}}</p>--%>
    <%--</div>--%>

    <div ng-controller="Hello">
        <p>
            {{userName}}
        </p>
        <ul>
            <li ng-repeat="car in cars">
                {{car.manufacturer}} {{car.model}} {{car.productionYear}} body style: {{car.bodyStyle}},
                only for {{car.price}}$. {{car.amountLeft}} cars left
                <br>
                {{car}}
            </li>
        </ul>
    </div>
</div>

<p>This is the <b>app-portlet</b> portlet v 1.0.2</p>

<c:out escapeXml="true" value="${releaseInfo}" />.

<script>
    var app = angular.module('myApp', []);
//    app.controller('userInfo', ['$scope', '$window', function($scope, $window){
//        $scope.userName = "",
//                $scope.getUserInfo = function() {
//                    $scope.userName = $window.Liferay.ThemeDisplay.getUserName();
//                };
//    }] );
    app.controller('Hello', ['$scope', '$window', '$http', function($scope, $window, $http) {
        $http.get('http://localhost:8000/car/all').then(function (response) {
            $scope.cars = response.data;
            $scope.userName = $window.Liferay.ThemeDisplay.getUserName();
        });
    }]);
</script>