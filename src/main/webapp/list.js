/**
 * Created by HHA on 07.04.2015.
 */
function List($scope, $http) {
    $http.get('http://scheckcheck-satspeedy.rhcloud.com/scheckcheck/resources/teilnehmer').
        success(function(data) {
            $scope.teilnehmers = data;
        });
}