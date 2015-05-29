/**
 * Created by HHA on 07.04.2015.
 */
function List($scope, $http) {
    $http.get('http://localhost:8080/scheckcheck/resources/teilnehmer').
        success(function(data) {
            $scope.members = data;
        });
}