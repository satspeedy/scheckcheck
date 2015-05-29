/**
 * Created by HHA on 07.04.2015.
 */
function Hello($scope, $http) {
    $http.get('http://localhost:8080/scheckcheck/resources/teilnehmer/1').
        success(function(data) {
            $scope.member = data;
        });
}